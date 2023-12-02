package com.mobile.povar.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mobile.povar.data.room.dao.DaoCategory
import com.mobile.povar.data.room.dao.DaoCategoryRecipeCrossRef
import com.mobile.povar.data.room.dao.DaoRecipe
import com.mobile.povar.models.room.category.CategoryEntity
import com.mobile.povar.models.room.category.CategoryRecipeCrossRef
import com.mobile.povar.models.room.recipe.IngredientEntity
import com.mobile.povar.models.room.recipe.RecipeEntity
import com.mobile.povar.models.room.recipe.RecipeStepEntity

/**
 * [RoomDatabase] для работы с рецептами и их категориями
 */
@Database(
    entities = [
        CategoryEntity::class,
        IngredientEntity::class,
        RecipeEntity::class,
        RecipeStepEntity::class,
        CategoryRecipeCrossRef::class], version = 1
)
abstract class CookingBookDatabase : RoomDatabase() {

    abstract fun categoryDao(): DaoCategory

    abstract fun recipesDao(): DaoRecipe

    abstract fun categoryRecipeCrossRefDao(): DaoCategoryRecipeCrossRef

    companion object {
        const val DATABASE_NAME = "recipes_room_database"
    }
}
