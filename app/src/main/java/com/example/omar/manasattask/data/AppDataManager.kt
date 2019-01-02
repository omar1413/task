package com.example.omar.manasattask.data

import com.example.omar.manasattask.BuildConfig
import com.example.omar.manasattask.data.retrofit.RetrofitManager
import com.example.omar.manasattask.data.retrofit.pojo.popular.PopularRoot
import com.example.omar.manasattask.data.retrofit.service.PopularPeopleService
import io.reactivex.Single
import javax.inject.Inject

class AppDataManager :MvpModel {

    var retrofitManager:RetrofitManager? = null
   constructor(retrofitManager: RetrofitManager){
        this.retrofitManager = retrofitManager
   }

    override fun getPopularPeopleByPage(pageNum: Int): Single<PopularRoot> {
        val service = retrofitManager?.retrofit?.create(PopularPeopleService::class.java)
        return service!!.getPopularPeople(BuildConfig.API_KEY,pageNum)
    }
}