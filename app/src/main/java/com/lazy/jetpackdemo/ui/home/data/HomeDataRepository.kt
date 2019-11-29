package com.lazy.jetpackdemo.ui.home.data

import com.lazy.jetpackdemo.ui.home.db.HomeDao

class HomeDataRepository constructor(val  homeDao: HomeDao){
    fun getHomeData() =homeDao.getComponents()
    companion object{
        @Volatile private var instance: HomeDataRepository? = null
        fun getInstance(homeDap: HomeDao) =
            instance ?: synchronized(this) {
                instance ?: HomeDataRepository(homeDap).also { instance = it }
            }
    }
}