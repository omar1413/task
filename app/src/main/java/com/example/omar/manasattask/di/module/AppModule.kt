package com.example.omar.manasattask.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(var application: Application) {


    @Provides
    fun provideContext(): Context{
        return application
    }

    @Provides
    fun provideApplication(): Application{
        return application
    }



}