package com.mobile.povar.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.mobile.povar.models.room.category.CategoryRecipeCrossRef

@Dao
interface DaoCategoryRecipeCrossRef {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: CategoryRecipeCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<CategoryRecipeCrossRef>)

    @Delete
    suspend fun delete(data: CategoryRecipeCrossRef)
}