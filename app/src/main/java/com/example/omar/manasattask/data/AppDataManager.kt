package com.example.omar.manasattask.data

import com.example.omar.manasattask.BuildConfig
import com.example.omar.manasattask.data.prefs.PreferenceHelper
import com.example.omar.manasattask.data.retrofit.RetrofitManager
import com.example.omar.manasattask.data.retrofit.pojo.popular.PopularRoot
import com.example.omar.manasattask.data.retrofit.service.PopularPeopleService
import com.example.omar.manasattask.di.scope.AppScope
import io.reactivex.Single
import javax.inject.Inject


class AppDataManager :MvpModel {


    @Inject
    lateinit var retrofitManager:RetrofitManager

    @Inject
    lateinit var prefHelper: PreferenceHelper


    @Inject
   constructor(){
        //this.retrofitManager = retrofitManager
   }

    override fun getPopularPeopleByPage(pageNum: Int): Single<PopularRoot> {
        val service = retrofitManager.retrofit.create(PopularPeopleService::class.java)
        return service.getPopularPeople(BuildConfig.API_KEY,pageNum)
    }
    override fun getUserId(): Int? {
        return prefHelper.getUserDetailsId()
    }

    override fun setUserId(id: Int) {
        prefHelper.setUserDetailsId(id)
    }


}