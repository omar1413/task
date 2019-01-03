package com.example.omar.manasattask.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.omar.manasattask.di.qualifier.ActivityContextQualifier
import com.example.omar.manasattask.di.scope.ActivityScope
import com.example.omar.manasattask.ui.main.PopularPersonsMvpPresenter
import com.example.omar.manasattask.ui.main.PopularPersonsMvpView
import com.example.omar.manasattask.ui.main.PopularPersonsPresenter
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import dagger.Module
import dagger.Provides

@Module
class ActivityModule (val activity: AppCompatActivity){

    @ActivityContextQualifier
    @ActivityScope
    @Provides
    fun provideActivityContext(): Context{
        return activity
    }

    @ActivityScope
    @Provides
    fun providesPopularPersonsMvpPresenter(popularPersonsPresenter: PopularPersonsPresenter<PopularPersonsMvpView>): PopularPersonsMvpPresenter<PopularPersonsMvpView>{
        return popularPersonsPresenter
    }


    @ActivityScope
    @Provides
    fun providesLayoutManager( @ActivityContextQualifier context: Context): LinearLayoutManager{
        return LinearLayoutManager(context)
    }


    @ActivityScope
    @Provides
    fun providesGroupAdapter(): GroupAdapter<ViewHolder>{
        return GroupAdapter()
    }

}