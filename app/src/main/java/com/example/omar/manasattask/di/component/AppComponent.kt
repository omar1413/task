package com.example.omar.manasattask.di.component

import com.example.omar.manasattask.TaskApp
import com.example.omar.manasattask.di.module.AppModule
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(taskApp: TaskApp)
}