package com.example.omar.manasattask.di.component

import com.example.omar.manasattask.TaskApp
import com.example.omar.manasattask.data.MvpModel
import com.example.omar.manasattask.di.module.AppModule
import com.example.omar.manasattask.di.scope.AppScope
import dagger.Component
import retrofit2.Retrofit


@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {


    fun inject(taskApp: TaskApp)

    fun getMvpModel(): MvpModel

    fun getRetrofit():Retrofit
}