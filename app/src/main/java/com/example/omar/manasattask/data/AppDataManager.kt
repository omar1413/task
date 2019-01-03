package com.example.omar.manasattask.data

import com.example.omar.manasattask.data.prefs.PreferenceHelper
import com.example.omar.manasattask.data.retrofit.RetrofitManager
import com.example.omar.manasattask.data.retrofit.pojo.persondetails.PersonDetailsResponse
import com.example.omar.manasattask.data.retrofit.pojo.personimages.PersonImagesResponse
import com.example.omar.manasattask.data.retrofit.pojo.popular.PopularRoot
import io.reactivex.Single
import javax.inject.Inject


class AppDataManager : MvpModel {


    @Inject
    lateinit var retrofitManager: RetrofitManager

    @Inject
    lateinit var prefHelper: PreferenceHelper


    @Inject
    constructor() {
        //this.retrofitManager = retrofitManager
    }

    override fun getPopularPeopleByPage(pageNum: Int): Single<PopularRoot> {
        return retrofitManager.getPopularPeopleByPage(pageNum)
    }

    override fun getPersonDetails(personId: Int): Single<PersonDetailsResponse> {
        return retrofitManager.getPersonDetails(personId)
    }

    override fun getPersonImages(personId: Int): Single<PersonImagesResponse> {
        return retrofitManager.getPersonImages(personId)
    }

    override fun getUserDetailsId(): Int? {
        return prefHelper.getUserDetailsId()
    }

    override fun setUserDetailsId(id: Int) {
        prefHelper.setUserDetailsId(id)
    }

}