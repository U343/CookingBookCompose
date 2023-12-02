package com.mobile.povar.models.room.recipe

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Обьект рецептов для хранения в SQLite
 *
 * @property recipeId id рецепта, параметр проставляется автоматически
 * @property name Название рецепта
 * @property description Описание рецепта
 * @property imageUri Uri картинки рецепта в галерее устройства
 * @property isFavorite Является ли рецепт любимым
 */
@Entity
data class RecipeEntity(
    @ColumnInfo(name = "recipe_id") @PrimaryKey(autoGenerate = true) var recipeId: Long = 0,
    @ColumnInfo(name = "recipe_name") var name: String,
    @ColumnInfo(name = "recipe_description") var description: String,
    @ColumnInfo(name = "image_uri") var imageUri: String? = null,
    @ColumnInfo(name = "recipe_favorite_status") var isFavorite: Boolean = false
) {
    companion object {
        const val TABLE_NAME = "recipeDataEntity"
    }
}
