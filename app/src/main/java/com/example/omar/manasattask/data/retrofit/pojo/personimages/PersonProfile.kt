package com.example.omar.manasattask.data.retrofit.pojo.personimages

import com.google.gson.annotations.SerializedName

data class PersonProfile(
    val width: Int,
    val Height: Int,
    @SerializedName("file_path") val filePath: String,
    @SerializedName("aspect_ratio")val aspectRatio: Double,
    @SerializedName("vote_count")val voteCount: Int,
    @SerializedName("vote_average")val voteAverage: Double
)