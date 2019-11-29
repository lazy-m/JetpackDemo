package com.lazy.jetpackdemo.utilities


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.lazy.jetpackdemo.R

object BindingAdapter {
    @BindingAdapter("imageUrl" )
   @JvmStatic  fun loadImage(view :ImageView, url:String){
          Glide.with(view.context)
              .load(url)
              .error(R.mipmap.img_no)
              .into(view)
    }
}