package com.mobile.povar.models.room.recipe

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Обьект ингредиента рецепта для хранения в SQLite
 *
 * @property id Идентификатор ингредиента, параметр проставляется автоматически
 * @property recipeOwnerId Идентификатор рецепта к которому относится этот ингредиент
 * @property name Название ингредиента
 * @property description Описание ингредиента
 */
@Entity
data class IngredientEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "ingredient_id") var id: Long = 0,
    @ColumnInfo(name = "recipe_owner_id") var recipeOwnerId: Long = 0,
    @ColumnInfo(name = "ingredient_name") var name: String,
    @ColumnInfo(name = "ingredient_description") var description: String
) {
    companion object {
        const val TABLE_NAME = "ingredientEntity"
    }
}