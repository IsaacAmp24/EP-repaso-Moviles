package com.example.semana07_1_repaso

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "postTable")
data class TablePost(

    @PrimaryKey()

    val id:Int?,

    @ColumnInfo(name="userId")

    val userId:Int?,

    @ColumnInfo(name="body")

    val body:String?,

    @ColumnInfo(name="title")

    val title:String?


)