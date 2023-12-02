package com.mobile.povar.models.room.category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Обьект категорий для хранения в SQLite
 *
 * @property id id категрии, параметр проставляется автоматически
 * @property name Название категории
 * @property recipesCount Количество рецептов в данной категории
 */
@Entity
data class CategoryEntity(
    @ColumnInfo(name = "category_id") @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "category_name") var name: String,
    @ColumnInfo(name = "category_recipes_count") var recipesCount: Int = 0
) {
    companion object {
        const val TABLE_NAME = "categoryEntity"
    }
}
