package com.lazy.jetpackdemo.ui.pagingShow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.lazy.jetpackdemo.bean.Song
import com.lazy.jetpackdemo.databinding.ItemSongLayoutBinding

class SongListAdapter : PagedListAdapter<Song,SongListAdapter.customizeViewHolder>(diffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customizeViewHolder {
        return customizeViewHolder(ItemSongLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: customizeViewHolder, position: Int) {
      return holder.bind(getItem(position))
    }

    companion object{
        val diffCallback =object :DiffUtil.ItemCallback<Song>(){
            override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
                return  oldItem.id==oldItem.id
            }
            override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
               return oldItem==newItem
            }
        }
    }


    class  customizeViewHolder(val binding: ItemSongLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(song:Song?){
            binding.song =song
            binding.executePendingBindings()
        }
    }
}