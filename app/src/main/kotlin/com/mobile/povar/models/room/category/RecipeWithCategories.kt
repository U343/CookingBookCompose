package com.mobile.povar.models.room.category

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.mobile.povar.models.room.recipe.RecipeEntity

/**
 * Модель рецепта с категорими, в которых этот рецепт находится
 *
 * @property recipe модель рецепта
 * @property categories категории, связанные с данным рецептом
 */
data class RecipeWithCategories(
    @Embedded val recipe: RecipeEntity,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "category_id",
        associateBy = Junction(CategoryRecipeCrossRef::class)
    )
    val categories: List<CategoryEntity>
)