package com.example.omar.manasattask.data.retrofit.service

import com.example.omar.manasattask.data.retrofit.pojo.persondetails.PersonDetailsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PersonDetailsService {

    @GET("/person/{person_id}")
    fun getPersonDetails(@Path("person_id")personId: Int,
                         @Query("api_key")apiKey: String
    ): Single<PersonDetailsResponse>
}