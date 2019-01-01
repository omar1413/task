package com.example.omar.manasattask.data.retrofit.service

import com.example.omar.manasattask.data.retrofit.pojo.popular.PopularRoot
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularPeopleService {

    @GET("/person/popular")
    fun getPopularPeople(
        @Query("api_key") apiKey: String,
        @Query("language") lang: String,
        @Query("page") pageNum: Int
    ): Single<PopularRoot>
}