package com.example.omar.manasattask.data.retrofit.pojo.popular

import com.google.gson.annotations.SerializedName

data class PopularRoot(
    val page: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results")val totalResults:Int,
    val results: List<PopularResult>
)