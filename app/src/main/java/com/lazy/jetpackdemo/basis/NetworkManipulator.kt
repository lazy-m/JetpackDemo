package com.lazy.jetpackdemo.basis

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.lazy.jetpackdemo.base.BaseDean
import com.lazy.jetpackdemo.utilities.NetworkState

/**
 *  pagedList ： 数据列表
 * networkState ： 网络状态
 * refreshState ： 刷新状态
 * refresh ： 刷新操作
 * retry ： 重试操作
 */
data class NetworkManipulator<T>(
    // the livedata of paged lists for the ui to observe
    val pagedList: LiveData<PagedList<T>>,
    // represents the network request status to show to the user
    val networkState: LiveData<NetworkState>,
    // represents the refresh status to show to the user. Separate from networkState, this
    // value is importantly only when refresh is requested.
    val refreshState: LiveData<NetworkState>,
    // refreshes the whole data and fetches it from scratch.
    val refresh: () -> Unit,
    // retries any failed requests.
    val retry: () -> Unit
)