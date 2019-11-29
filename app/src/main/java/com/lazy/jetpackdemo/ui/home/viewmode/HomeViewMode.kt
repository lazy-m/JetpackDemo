package com.lazy.jetpackdemo.ui.home.viewmode

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lazy.jetpackdemo.bean.Component
import com.lazy.jetpackdemo.ui.home.data.HomeDataRepository


class HomeViewMode internal constructor(homeDataRepository: HomeDataRepository):ViewModel(){
    val getHomeLIstData :LiveData<List<Component>> =homeDataRepository.getHomeData()
}