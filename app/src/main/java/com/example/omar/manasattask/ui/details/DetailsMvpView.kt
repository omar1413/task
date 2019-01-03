package com.example.omar.manasattask.ui.details

import com.example.omar.manasattask.data.retrofit.pojo.persondetails.PersonDetailsResponse
import com.example.omar.manasattask.ui.base.MvpView

interface DetailsMvpView: MvpView{


    fun fillData(personDetails: PersonDetailsResponse)

    fun addImageItem(uri: String)

}