package com.mobile.povar.models.room.category

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.mobile.povar.models.room.recipe.RecipeEntity

/**
 * Модель категории с рецептами, которые хранятся в этой категории
 *
 * @property category Модель категории
 * @property recipes Рецепты, относящиеся к этой категории
 */
data class CategoryWithRecipes(
    @Embedded val category: CategoryEntity,
    @Relation(
        parentColumn = "category_id",
        entityColumn = "recipe_id",
        associateBy = Junction(CategoryRecipeCrossRef::class)
    )
    val recipes: List<RecipeEntity>
)