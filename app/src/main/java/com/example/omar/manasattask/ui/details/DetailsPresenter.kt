package com.example.omar.manasattask.ui.details

import com.example.omar.manasattask.data.MvpModel
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
            val response = dataManager.getPersonDetails(id)

            val disposable = response.subscribeOn(Schedulers.io())
                .toObservable()
                .flatMap { it->
                    Observable.just(it)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    mvpView?.showMessage(it.message!!)
                }
                .subscribe{
                    if (mvpView != null){
                        mvpView?.fillData(it)
                    }
                }

        }
    }


    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        getUserDetails()
    }

}