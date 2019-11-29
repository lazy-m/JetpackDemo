package com.lazy.jetpackdemo.bean

import com.lazy.jetpackdemo.base.BaseDean

 data class Beauty(
    val _id:String,
    val createdAt:String,
    val desc:String,
    val publishedAt:String,
    val source:String,
    val type:String,
    val url:String,
    val used:String,
    val who:String
)

 class BeautyResponse(
val error:Boolean,
val results: List<Beauty>
):BaseDean()