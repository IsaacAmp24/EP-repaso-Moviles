package com.example.semana07_1_repaso

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostDao {

    @Query("SELECT * FROM postTable")
    fun getAll(): List<Post>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tablePost: TablePost)

}