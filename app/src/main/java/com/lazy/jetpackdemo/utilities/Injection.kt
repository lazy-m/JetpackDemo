package com.lazy.jetpackdemo.utilities

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.lazy.jetpackdemo.net.Api
import com.lazy.jetpackdemo.net.HttpClient

object Injection {

    fun provideApi(): Api = HttpClient.instance

    fun activityTiaozhuan(ctx: Context,clazz:Class<Any>){
        var intent = Intent()
        intent.setClass(ctx,clazz)
        startActivity(ctx,intent,null)
    }
}