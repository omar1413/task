package com.example.omar.manasattask.data.retrofit.pojo.popular

import com.google.gson.annotations.SerializedName

data class PopularResult(
    val id: Int,
    val name: String,
    val popularity: Float,
    @SerializedName("profile_path")val profilePath:String
)