package com.mobile.povar.models.room.recipe

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Обьект шага рецепта для хранения в SQLite
 *
 * @property id Идентификатор шага рецепта, параметр проставляется автоматически
 * @property recipeOwnerId Название рецепта к которому относится шаг
 * @property name Описание шага рецепта
 * @property content Контент шага
 */
@Entity
data class RecipeStepEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "step_id") var id: Long = 0,
    @ColumnInfo(name = "recipe_owner_id") var recipeOwnerId: Long = 0,
    @ColumnInfo(name = "step_name") val name: String,
    @ColumnInfo(name = "step_content") val content: String
) {
    companion object {
        const val TABLE_NAME = "recipeStepEntity"
    }
}