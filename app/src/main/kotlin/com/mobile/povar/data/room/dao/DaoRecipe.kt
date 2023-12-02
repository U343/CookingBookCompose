package com.mobile.povar.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.mobile.povar.models.room.category.CategoryEntity
import com.mobile.povar.models.room.category.CategoryWithRecipes
import com.mobile.povar.models.room.category.RecipeWithCategories
import com.mobile.povar.models.room.recipe.IngredientEntity
import com.mobile.povar.models.room.recipe.RecipeEntity
import com.mobile.povar.models.room.recipe.RecipeStepEntity
import com.mobile.povar.models.room.recipe.RecipeWithIngredientsAndSteps
import kotlinx.coroutines.flow.Flow

/**
 * Объект для доступа к данным рецептов
 */
@Dao
interface DaoRecipe {

    /**
     * Сохраняет рецепт вместе с его ингредиентами, шагами и категориями
     *
     * Между рецептом и его категориями с шагами установлена связть one-to-many и для каждой
     * сущности есть своя таблица. К тому же для сохранения шагов и ингредиентов нужен id рецепта, который
     * можно получить только после того как этот рецепт будет записан в БД. Для корректного сохранения
     * всех сущностей и нужен этот метод
     *
     * @param recipeData Данные рецепта
     */
    suspend fun insertRecipe(recipeData: RecipeWithIngredientsAndSteps): Long {
        val recipeId = insertRecipeData(recipeData.recipe)
        with(recipeData) {
            ingredients.forEach { ingredient -> ingredient.recipeOwnerId = recipeId }
            steps.forEach { step -> step.recipeOwnerId = recipeId }
            insertIngredients(ingredients)
            insertSteps(steps)
        }
        return recipeId
    }

    /**
     * Удаляет рецепт вместе с его ингредиентами и шагами
     *
     * @param recipeData Данные рецепта
     */
    suspend fun deleteRecipe(recipeData: RecipeWithIngredientsAndSteps) {
        with(recipeData) {
            deleteRecipeData(recipe)
            ingredients.forEach { deleteIngredient(it) }
            steps.forEach { deleteStep(it) }
        }
    }

    @Query("SELECT * FROM ${RecipeEntity.TABLE_NAME}")
    fun getAll(): Flow<List<RecipeEntity>>

    @Query("SELECT * FROM ${RecipeEntity.TABLE_NAME} WHERE recipe_id LIKE :recipeId  LIMIT 1")
    suspend fun getRecipeById(recipeId: Long): RecipeEntity

    @Transaction
    @Query("SELECT * FROM ${RecipeEntity.TABLE_NAME}")
    suspend fun getListRecipesWithCategories(): List<RecipeWithCategories>

    @Transaction
    @Query("SELECT * FROM ${CategoryEntity.TABLE_NAME}")
    suspend fun getListCategoriesWithRecipes(): List<CategoryWithRecipes>

    /**
     * Получить все рецепты у которых favorite_status == true
     *
     * SQL Lite хранит логические данные как цифры 1 (true) и 0 (false)
     */
    @Query("SELECT * FROM ${RecipeEntity.TABLE_NAME} WHERE recipe_favorite_status = 1")
    suspend fun getFavoriteRecipes(): List<RecipeEntity>

    @Update
    suspend fun update(recipe: RecipeEntity)

    @Delete
    suspend fun deleteRecipeData(recipe: RecipeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipeData(recipe: RecipeEntity): Long

    @Insert
    suspend fun insertIngredients(ingredients: List<IngredientEntity>)

    @Delete
    suspend fun deleteIngredient(ingredient: IngredientEntity)

    @Insert
    suspend fun insertSteps(ingredients: List<RecipeStepEntity>)

    @Delete
    suspend fun deleteStep(steps: RecipeStepEntity)

    @Transaction
    @Query("SELECT * FROM ${RecipeEntity.TABLE_NAME}")
    suspend fun getAllRecipesWithIngredientsAndSteps(): List<RecipeWithIngredientsAndSteps>

    @Transaction
    @Query("SELECT * FROM ${RecipeEntity.TABLE_NAME} WHERE recipe_id LIKE :recipeId")
    suspend fun getRecipesWithIngredientsAndStepsById(recipeId: Long): RecipeWithIngredientsAndSteps
}
