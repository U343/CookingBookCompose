package com.mobile.povar.models.room.category

import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 * Модель для реализации связи many-to-many между категориями и рецептами
 *
 * В таблице хранятся ссылки на категорию и рецепт, которые связаны между собой.
 * В категории может хранится несколько рецептов, один рецепт может находиться
 * в нескольких категориях
 *
 * @property categoryId id категрии
 * @property recipeId id рецепта
 */
@Entity(primaryKeys = ["category_id", "recipe_id"])
data class CategoryRecipeCrossRef(
    @ColumnInfo(name = "category_id") val categoryId: Int,
    @ColumnInfo(name = "recipe_id") val recipeId: Long
)