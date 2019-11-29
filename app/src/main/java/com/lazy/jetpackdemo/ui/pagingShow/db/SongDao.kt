package com.lazy.jetpackdemo.ui.pagingShow.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lazy.jetpackdemo.bean.Song

@Dao
interface SongDao {

 @Query("SELECT * FROM Song ORDER BY songName COLLATE NOCASE ASC")
 fun queryUsersByName(): DataSource.Factory<Int, Song>

 @Insert
 fun insert(users: List<Song>)
}