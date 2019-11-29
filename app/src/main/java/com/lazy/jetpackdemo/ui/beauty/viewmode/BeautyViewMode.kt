package com.lazy.jetpackdemo.ui.beauty.viewmode

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.lazy.jetpackdemo.basis.NetworkManipulator
import com.lazy.jetpackdemo.bean.Beauty
import com.lazy.jetpackdemo.ui.beauty.data.BeautySourceFactory

class BeautyViewMode :ViewModel(){

    private  val PAGE_SIZE = 20

    val gankList = getResult().pagedList

    fun  getResult():NetworkManipulator<Beauty>{
        val sourceFactory = BeautySourceFactory()
        val config = PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setInitialLoadSizeHint(PAGE_SIZE * 2)
            .setEnablePlaceholders(false)
            .build()
        val livePageList = LivePagedListBuilder<Int, Beauty>(sourceFactory, config).build()
        val refreshState = Transformations.switchMap(sourceFactory.sourceLiveData) { it.initialLoad }
        return NetworkManipulator(
            pagedList = livePageList,
            networkState = Transformations.switchMap(sourceFactory.sourceLiveData) { it.netWorkState },
            retry = { sourceFactory.sourceLiveData.value?.retryAllFailed() },
            refresh = { sourceFactory.sourceLiveData.value?.invalidate() },
            refreshState = refreshState
        )
    }
}