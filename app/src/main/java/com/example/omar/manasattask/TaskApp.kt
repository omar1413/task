package com.example.omar.manasattask

import android.app.Application
import com.example.omar.manasattask.di.component.AppComponent
import com.example.omar.manasattask.di.component.DaggerAppComponent
import com.example.omar.manasattask.di.module.AppModule

class TaskApp: Application() {

    var component: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        //component?.inject(this)
    }




}