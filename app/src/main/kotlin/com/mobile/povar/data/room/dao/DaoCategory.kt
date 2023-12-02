package com.mobile.povar.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mobile.povar.models.room.category.CategoryEntity
import kotlinx.coroutines.flow.Flow

/**
 * Объект для доступа к данным категорий
 */
@Dao
interface DaoCategory {

    @Query("SELECT * FROM ${CategoryEntity.TABLE_NAME}")
    fun getAll(): Flow<List<CategoryEntity>>

    @Query("SELECT * FROM ${CategoryEntity.TABLE_NAME} WHERE category_id LIKE :categoryId  LIMIT 1")
    suspend fun getCategoryById(categoryId: Int): CategoryEntity

    @Update
    suspend fun update(recipe: CategoryEntity)

    @Delete
    suspend fun delete(category: CategoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: CategoryEntity)
}
