package com.example.omar.manasattask.di.component

import com.example.omar.manasattask.di.module.ActivityModule
import com.example.omar.manasattask.ui.main.PopularPersonsActivity
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent{

    //fun inject(popularPersonsActivity: PopularPersonsActivity)
}