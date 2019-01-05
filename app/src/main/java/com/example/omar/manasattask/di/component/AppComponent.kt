package com.example.omar.manasattask.di.component

import android.net.ConnectivityManager
import com.example.omar.manasattask.TaskApp
import com.example.omar.manasattask.data.MvpModel
import com.example.omar.manasattask.di.module.AppModule
import com.example.omar.manasattask.di.scope.AppScope
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity
import dagger.Component
import io.reactivex.Observable
import retrofit2.Retrofit


@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {


    fun inject(taskApp: TaskApp)

    fun getMvpModel(): MvpModel

    fun getRetrofit():Retrofit

    fun getNetworkConnectivity(): Observable<Connectivity>

    fun getConnectivityManager():ConnectivityManager
}