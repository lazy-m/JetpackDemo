package com.lazy.jetpackdemo.base

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class BasePagedAdapter<T:BaseDean>(vh:RecyclerView.ViewHolder):PagedListAdapter<T,RecyclerView.ViewHolder>(Diff<T>()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class Diff<T : BaseDean> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(item: T, item1: T) = item.id == item1.id

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(item: T, item1: T) = item == item1
    }

}