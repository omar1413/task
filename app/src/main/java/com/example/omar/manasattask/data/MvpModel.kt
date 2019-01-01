package com.example.omar.manasattask.data

import com.example.omar.manasattask.data.retrofit.pojo.popular.PopularRoot
import io.reactivex.Single

interface MvpModel {


    fun getPopularPeopleByPage(pageNum: Int): Single<PopularRoot>
}