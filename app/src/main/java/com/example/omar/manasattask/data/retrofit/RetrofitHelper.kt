package com.example.omar.manasattask.data.retrofit

import com.example.omar.manasattask.data.retrofit.pojo.persondetails.PersonDetailsResponse
import com.example.omar.manasattask.data.retrofit.pojo.personimages.PersonImagesResponse
import com.example.omar.manasattask.data.retrofit.pojo.popular.PopularRoot
import io.reactivex.Single

interface RetrofitHelper{


    fun getPopularPeopleByPage(pageNum: Int): Single<PopularRoot>


    fun getPersonDetails(personId: Int): Single<PersonDetailsResponse>


    fun getPersonImages(personId: Int): Single<PersonImagesResponse>
    fun getPerson(query: String, pageNum: Int): Single<PopularRoot>
}