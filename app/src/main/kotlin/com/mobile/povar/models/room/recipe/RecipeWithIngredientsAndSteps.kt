package com.mobile.povar.models.room.recipe

import androidx.room.Embedded
import androidx.room.Relation
import com.mobile.povar.models.room.recipe.IngredientEntity
import com.mobile.povar.models.room.recipe.RecipeEntity
import com.mobile.povar.models.room.recipe.RecipeStepEntity

/**
 * Модель рецепта с ингредиентами и шагами этого рецепта
 *
 * @property recipe Рецепт
 * @property ingredients Ингредиенты
 * @property steps Шаги рецепта
 */
data class RecipeWithIngredientsAndSteps(
    @Embedded
    val recipe: RecipeEntity,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "recipe_owner_id"
    )
    val ingredients: List<IngredientEntity>,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "recipe_owner_id"
    )
    val steps: List<RecipeStepEntity>
)
