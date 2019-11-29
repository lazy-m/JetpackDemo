package com.lazy.jetpackdemo.net.respository.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.lazy.jetpackdemo.bean.Beauty
import com.lazy.jetpackdemo.bean.BeautyResponse
import com.lazy.jetpackdemo.net.Api
import com.lazy.jetpackdemo.utilities.Injection
import com.lazy.jetpackdemo.utilities.NetworkState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class BeautyDataSource (val  api:Api =Injection.provideApi()): PageKeyedDataSource<Int, Beauty>() {
    private var retry: (() -> Any)? = null
    val initialLoad = MutableLiveData<NetworkState>()
    val netWorkState = MutableLiveData<NetworkState>()

    fun retryAllFailed (){
        val prevRetry = retry
        retry = null
        prevRetry?.also { it.invoke() }
    }
    override fun loadInitial(  //初始加载
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Beauty>
    ) {
        initialLoad.postValue(NetworkState.LOADED)
        netWorkState.postValue(NetworkState.HIDDEN)
        api.getGank(params.requestedLoadSize,1)
            .enqueue(object : Callback<BeautyResponse>{
                override fun onFailure(call: Call<BeautyResponse>, t: Throwable) {
                    //加载失败时 重试加载
                    retry={
                        loadInitial(params,callback)
                    }
                    initialLoad.postValue(NetworkState.FAILED)
                }

                override fun onResponse(call: Call<BeautyResponse>, response: Response<BeautyResponse>) {
                    //加载成功操作
                    if (response.isSuccessful){
                        retry=null
                        callback.onResult(
                            response.body()?.results ?: emptyList(),
                            null,
                            2
                        )
                        initialLoad.postValue(NetworkState.LOADED)
                        Log.e("text","===="+response.body())
                    }else{
                        retry ={
                            loadInitial(params, callback)
                        }
                        initialLoad.postValue(NetworkState.FAILED)
                    }
                }
            })
    }

    /**
     *   下拉加载时
     */
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Beauty>) {
        netWorkState.postValue(NetworkState.LOADING)
        api.getGank(params.requestedLoadSize, params.key)
            .enqueue(object :Callback<BeautyResponse>{
                override fun onFailure(call: Call<BeautyResponse>, t: Throwable) {
                    retry ={
                        loadAfter(params,callback)
                    }
                    netWorkState.postValue(NetworkState.FAILED)
                }

                override fun onResponse(
                    call: Call<BeautyResponse>,
                    response: Response<BeautyResponse>
                ) {
                    if (response.isSuccessful) {
                        callback.onResult(
                            response.body()?.results ?: emptyList(),
                            params.key + 1
                        )
                        netWorkState.postValue(NetworkState.LOADED)
                    }else{
                        retry = {
                            loadAfter(params, callback)
                        }
                        netWorkState.postValue(NetworkState.FAILED)
                    }
                }

            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Beauty>) {

    }

}