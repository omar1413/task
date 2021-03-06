package com.example.omar.manasattask.di.module

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.example.omar.manasattask.BuildConfig
import com.example.omar.manasattask.data.AppDataManager
import com.example.omar.manasattask.data.MvpModel
import com.example.omar.manasattask.data.prefs.AppPreferenceHelper
import com.example.omar.manasattask.data.prefs.PreferenceHelper
import com.example.omar.manasattask.data.retrofit.RetrofitManager
import com.example.omar.manasattask.di.qualifier.AppContextQualifier
import com.example.omar.manasattask.di.qualifier.BaseUrlQualifier
import com.example.omar.manasattask.di.qualifier.PrefInfoQualifier
import com.example.omar.manasattask.di.scope.AppScope
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity
import com.github.pwittchen.reactivenetwork.library.rx2.ConnectivityPredicate
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(var application: Application) {


    @AppScope
    @AppContextQualifier
    @Provides
    fun provideContext(): Context{
        return application
    }

    @AppScope
    @AppContextQualifier
    @Provides
    fun provideApplication(): Application{
        return application
    }


    @AppScope
    @Provides
    fun providesMvpModel(appDataManager: AppDataManager):MvpModel{
        return appDataManager
    }


//    @AppScope
//    @Provides
//    fun providesRetrofitManager(): RetrofitManager{
//        return RetrofitManager()
//    }


    @AppScope
    @Provides
    fun providesRetrofit(@BaseUrlQualifier baseUrl:String, client: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @BaseUrlQualifier
    @AppScope
    @Provides
    fun providesBaseUrl():String{
        return BuildConfig.BASE_URL
    }

    @AppScope
    @Provides
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient{
        val okHttpClientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG){
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }

        return okHttpClientBuilder.build()
    }


    @AppScope
    @Provides
    fun providesLoggingInterceptor():HttpLoggingInterceptor{
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        return loggingInterceptor
    }

    @PrefInfoQualifier
    @AppScope
    @Provides
    fun prividePrefFileName():String{
        return "tasl_pref"
    }

    @AppScope
    @Provides
    fun providesPrefsHelper(appPrefs: AppPreferenceHelper): PreferenceHelper{
        return appPrefs
    }


    @AppScope
    @Provides
    fun providesNetworkConnectivity(@AppContextQualifier context: Context): Observable<Connectivity> {
        return ReactiveNetwork.observeNetworkConnectivity(context)
    }


    @AppScope
    @Provides
    fun providesConnectivityManager(@AppContextQualifier context: Context): ConnectivityManager{
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }



}