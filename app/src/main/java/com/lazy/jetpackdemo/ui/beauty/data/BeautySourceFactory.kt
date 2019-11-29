package com.lazy.jetpackdemo.ui.beauty.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.lazy.jetpackdemo.bean.Beauty
import com.lazy.jetpackdemo.net.Api
import com.lazy.jetpackdemo.net.respository.datasource.BeautyDataSource
import com.lazy.jetpackdemo.utilities.Injection

class BeautySourceFactory(val  api:Api=Injection.provideApi()):DataSource.Factory<Int,Beauty>(){

    val sourceLiveData = MutableLiveData<BeautyDataSource>()

    override fun create(): DataSource<Int, Beauty> {
        val source =BeautyDataSource(api)
        sourceLiveData.postValue(source)
        return  source
    }
}