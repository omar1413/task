package com.example.omar.manasattask.di.module

import android.app.Application
import android.content.Context
import com.example.omar.manasattask.BuildConfig
import com.example.omar.manasattask.data.AppDataManager
import com.example.omar.manasattask.data.MvpModel
import com.example.omar.manasattask.data.retrofit.RetrofitManager
import com.example.omar.manasattask.di.qualifier.AppContextQualifier
import com.example.omar.manasattask.di.qualifier.BaseUrlQualifier
import com.example.omar.manasattask.di.scope.AppScope
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(var application: Application) {


    @AppScope
    @AppContextQualifier
    @Provides
    fun provideContext(): Context{
        return application
    }

    @AppScope
    @AppContextQualifier
    @Provides
    fun provideApplication(): Application{
        return application
    }


    @AppScope
    @Provides
    fun providesMvpModel(appDataManager: AppDataManager):MvpModel{
        return appDataManager
    }


//    @AppScope
//    @Provides
//    fun providesRetrofitManager(): RetrofitManager{
//        return RetrofitManager()
//    }


    @AppScope
    @Provides
    fun providesRetrofit(@BaseUrlQualifier baseUrl:String, client: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @BaseUrlQualifier
    @AppScope
    @Provides
    fun providesBaseUrl():String{
        return BuildConfig.BASE_URL
    }

    @AppScope
    @Provides
    fun providesOkHttpClient(): OkHttpClient{
        return OkHttpClient()
    }



}