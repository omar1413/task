package com.example.omar.manasattask.data.retrofit.service

import com.example.omar.manasattask.data.retrofit.pojo.personimages.PersonImagesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PersonImagesService {
    @GET("person/{person_id}/images")
    fun getPersonImages(
        @Path("person_id") personId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") lang: String
    ): Single<PersonImagesResponse>
}