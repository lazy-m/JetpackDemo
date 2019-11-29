package com.lazy.jetpackdemo.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "component")
data class Component(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: String,
    val title: String,
    val description: String,
    val link: String
)