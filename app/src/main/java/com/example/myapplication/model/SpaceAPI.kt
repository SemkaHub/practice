package com.example.myapplication.model

import com.example.myapplication.RetrofitClient
import retrofit2.Call
import retrofit2.http.GET

interface SpaceAPI {
    @GET("api/v2/articles")
    fun getNews(): Call<MutableList<NewsModel>>

    companion object Factory {
        private const val BASE_URL = "https://www.spaceflightnewsapi.net/"

        val spaceAPI: SpaceAPI
            get() = RetrofitClient.getClient(BASE_URL).create(SpaceAPI::class.java)
    }
}