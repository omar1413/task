package com.example.omar.manasattask.ui.details

import android.util.Log
import com.example.omar.manasattask.BuildConfig
import com.example.omar.manasattask.data.MvpModel
import com.example.omar.manasattask.data.retrofit.pojo.persondetails.PersonDetailsResponse
import com.example.omar.manasattask.data.retrofit.pojo.personimages.PersonProfile
import com.example.omar.manasattask.ui.base.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject


class DetailsPresenter<V : DetailsMvpView> @Inject constructor(val dataManager:MvpModel): BasePresenter<V>(),DetailsMvpPresenter<V>{



    override fun getUserDetails() {
        val id = dataManager.getUserDetailsId()
        if (id != null) {
//            val response1 = dataManager.getPersonDetails(id).subscribeOn(Schedulers.io()).toObservable()
//            val response2 = dataManager.getPersonImages(id).subscribeOn(Schedulers.io()).toObservable()



            val response1  = checkNetwork(dataManager.getPersonDetails(id)).subscribeOn(Schedulers.io())
                .flatMap { it->
                    Observable.just(it)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    mvpView?.showMessage(it.message!!)
                }

            val response2 = checkNetwork(dataManager.getPersonImages(id))
                .subscribeOn(Schedulers.io())
                .map {
                    it.profiles
                }
                .flatMap {
                    Observable.fromIterable(it)
                }
                .doOnError {
                    Log.d("","")
                }
                .observeOn(AndroidSchedulers.mainThread())

            Observable.merge(response1,response2).observeOn(AndroidSchedulers.mainThread())
                .subscribe({it
                    if(mvpView == null)
                        return@subscribe
                    when(it){
                        is PersonDetailsResponse -> mvpView?.fillData(it)
                        is PersonProfile -> mvpView?.addImageItem(BuildConfig.Base_IMAGE_URL + it.filePath)
                    }
                },{
                    Log.d("","")
                })




        }
    }


    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        getUserDetails()
    }

}