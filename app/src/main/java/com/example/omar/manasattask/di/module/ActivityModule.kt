package com.example.omar.manasattask.di.module

import com.example.omar.manasattask.ui.main.PopularPersonsMvpPresenter
import com.example.omar.manasattask.ui.main.PopularPersonsMvpView
import com.example.omar.manasattask.ui.main.PopularPersonsPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    fun providesPopularPersonsMvpPresenter(popularPersonsPresenter: PopularPersonsPresenter<PopularPersonsMvpView>): PopularPersonsMvpPresenter<PopularPersonsMvpView>{
        return popularPersonsPresenter
    }

}