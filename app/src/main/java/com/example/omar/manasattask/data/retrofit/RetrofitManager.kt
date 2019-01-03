package com.example.omar.manasattask.data.retrofit

import com.example.omar.manasattask.BuildConfig
import com.example.omar.manasattask.data.retrofit.pojo.persondetails.PersonDetailsResponse
import com.example.omar.manasattask.data.retrofit.pojo.personimages.PersonImagesResponse
import com.example.omar.manasattask.data.retrofit.pojo.popular.PopularRoot
import com.example.omar.manasattask.data.retrofit.service.PersonDetailsService
import com.example.omar.manasattask.data.retrofit.service.PopularPeopleService
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitManager @Inject constructor() : RetrofitHelper {


    @Inject
    lateinit var retrofit: Retrofit

    override fun getPopularPeopleByPage(pageNum: Int): Single<PopularRoot> {
        val service = retrofit.create(PopularPeopleService::class.java)
        return service.getPopularPeople(BuildConfig.API_KEY, pageNum)
    }

    override fun getPersonDetails(personId: Int): Single<PersonDetailsResponse> {
        val service = retrofit.create(PersonDetailsService::class.java)
        return service.getPersonDetails(personId,BuildConfig.API_KEY)
    }

    override fun getPersonImages(): Single<PersonImagesResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}