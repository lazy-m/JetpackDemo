package com.lazy.jetpackdemo.utilities


import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.lazy.jetpackdemo.R
import com.lazy.jetpackdemo.ui.beauty.BeautyActivity
import com.lazy.jetpackdemo.ui.pagingShow.SongListActivity


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

    @BindingAdapter("onClick")
    @JvmStatic fun onClick(view:View,id:String){
        view.setOnClickListener {
            val intent = Intent()
            when(id){
                "9" -> int(view.context, intent.setClass(view.context,BeautyActivity::class.java))
                "6" -> int(view.context,intent.setClass(view.context,SongListActivity::class.java))
                else -> Toast.makeText(view.context,"暂未开放",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun int(context: Context,intent:Intent){
        startActivity(context, intent, null)
    }
}