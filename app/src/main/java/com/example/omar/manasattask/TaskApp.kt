package com.example.omar.manasattask

import android.app.Application
import com.example.omar.manasattask.di.component.AppComponent
import com.example.omar.manasattask.di.component.DaggerAppComponent
import com.example.omar.manasattask.di.module.AppModule
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity
import io.reactivex.Observable
import java.util.*
import javax.inject.Inject

class TaskApp: Application() {

    var component: AppComponent? = null

    @Inject
    lateinit var networkConnectivityObservable: Observable<Connectivity>

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        //component?.inject(this)
    }




}