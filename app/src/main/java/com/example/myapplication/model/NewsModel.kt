package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class NewsModel(
    @SerializedName("id") val id : String,
    @SerializedName("title") val title : String,
    @SerializedName("url") val url : String,
    @SerializedName("imageUrl") val imageUrl : String,
    @SerializedName("newsSite") val newsSite : String,
    @SerializedName("summary") val summary : String,
    @SerializedName("publishedAt") val publishedAt : String,
    @SerializedName("updatedAt") val updatedAt : String,
    @SerializedName("featured") val featured : Boolean
)
