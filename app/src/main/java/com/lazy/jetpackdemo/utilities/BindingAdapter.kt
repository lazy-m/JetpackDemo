package com.lazy.jetpackdemo.utilities


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.lazy.jetpackdemo.R

object BindingAdapter {
    @BindingAdapter("imageUrl" )
   @JvmStatic  fun loadImage(view :ImageView, url:String){
        //屏幕的宽高(px值）
        val  screenWidth =view.context.resources.displayMetrics.widthPixels
        val  screenheight =view.context.resources.displayMetrics.heightPixels
        //Item的宽度，或图片的宽高
        val  width =screenWidth/2
        val  height =screenheight/3
        Glide.with(view.context)
              .asBitmap()
              .override(width,height)
              .load(url)
              .error(R.mipmap.img_no)
              .into(view)
    }
}