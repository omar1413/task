package com.example.omar.manasattask.di.component

import com.example.omar.manasattask.di.module.ActivityModule
import com.example.omar.manasattask.di.scope.ActivityScope
import com.example.omar.manasattask.ui.main.PopularPersonsActivity
import dagger.Component


@ActivityScope
@Component(dependencies = [AppComponent::class],modules = [ActivityModule::class])
interface ActivityComponent{


    fun inject(popularPersonsActivity: PopularPersonsActivity)
}