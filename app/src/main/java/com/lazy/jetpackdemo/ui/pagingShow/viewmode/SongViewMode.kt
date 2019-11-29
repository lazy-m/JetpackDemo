package com.lazy.jetpackdemo.ui.pagingShow.viewmode

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.paging.Config
import androidx.paging.toLiveData
import com.lazy.jetpackdemo.ui.home.db.HomeDB
import com.lazy.jetpackdemo.ui.pagingShow.db.SongDb


class SongViewMode (app: Application): AndroidViewModel(app){
    val daoSong = SongDb.get(app).songDao()
    val daohome =HomeDB.getInstance(app).homeDao()

    val allhome =daohome.getComponents()

    val  allSong =daoSong.queryUsersByName().toLiveData(
        Config(
            pageSize = 30,
            enablePlaceholders = true,
            maxSize = 200)
    )
}