package com.example.omar.manasattask.data.retrofit.service

import com.example.omar.manasattask.data.retrofit.pojo.popular.PopularRoot
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {

    @GET("search/person")
    fun searchForPopularPeople(
        @Query("query")query: String,
        @Query("api_key") apiKey: String,
        @Query("page") pageNum:Int
        ): Single<PopularRoot>
}