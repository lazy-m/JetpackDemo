package com.lazy.jetpackdemo.net

import com.lazy.jetpackdemo.bean.BeautyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("data/福利/{count}/{page}")
    fun getGank(
        @Path("count") count: Int,
        @Path("page") page: Int
    ): Call<BeautyResponse>
}