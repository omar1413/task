package com.example.omar.manasattask.data.retrofit

import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitManager private constructor(){

    private var instance: RetrofitManager? = null

    @Inject
    lateinit var retrofit: Retrofit

    fun getInstance(): RetrofitManager{
        if(instance == null){
            instance = this
        }
        return instance!!
    }

}