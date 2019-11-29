package com.lazy.jetpackdemo.bean

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "song")
data class Song(@PrimaryKey(autoGenerate = true) val id :Int, val  songName:String)