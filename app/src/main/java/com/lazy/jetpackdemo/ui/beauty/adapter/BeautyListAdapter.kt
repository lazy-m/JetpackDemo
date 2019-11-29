package com.lazy.jetpackdemo.ui.beauty.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.lazy.jetpackdemo.bean.Beauty
import com.lazy.jetpackdemo.databinding.ItemBeautyBinding

class BeautyListAdapter : PagedListAdapter<Beauty,BeautyListAdapter.customizeViewHolder>(diffCallback){

    class  customizeViewHolder(val binding: ItemBeautyBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(beauty: Beauty?){
            binding.beauty =beauty
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customizeViewHolder =
        customizeViewHolder(ItemBeautyBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: customizeViewHolder, position: Int) {
      val  item =getItem(position)
        holder.bind(item)
    }

    companion object{
        val diffCallback=object :DiffUtil.ItemCallback<Beauty>(){
            override fun areItemsTheSame(oldItem: Beauty, newItem: Beauty): Boolean =
                oldItem._id==newItem._id

            override fun areContentsTheSame(oldItem: Beauty, newItem: Beauty): Boolean =
                oldItem._id==oldItem._id

        }
    }
}