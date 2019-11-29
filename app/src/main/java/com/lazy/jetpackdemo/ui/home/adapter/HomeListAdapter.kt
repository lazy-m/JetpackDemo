package com.lazy.jetpackdemo.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lazy.jetpackdemo.bean.Component
import com.lazy.jetpackdemo.databinding.ListItemHomeBinding

class HomeListAdapter : ListAdapter<Component, HomeListAdapter.ViewHolder>((ComponentDiffCallback())) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemHomeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.apply {
            bind(item)
            itemView.tag = item
        }
    }


    class ViewHolder(
        private val binding: ListItemHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Component) {
            binding.apply {
                component = item
                executePendingBindings()
            }
        }
    }
}

private class ComponentDiffCallback : DiffUtil.ItemCallback<Component>() {

    override fun areItemsTheSame(oldItem: Component, newItem: Component): Boolean {
        return oldItem.link == newItem.link
    }

    override fun areContentsTheSame(oldItem: Component, newItem: Component): Boolean {
        return oldItem == newItem
    }
}