package com.example.omar.manasattask.ui.details

import com.example.omar.manasattask.data.MvpModel
import com.example.omar.manasattask.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class DetailsPresenter<V : DetailsMvpView> (val dataManager:MvpModel): BasePresenter<V>(),DetailsMvpPresenter<V>{



    override fun getUserDetails() {
        val id = dataManager.getUserDetailsId()
        if (id != null) {
            val response = dataManager.getPersonDetails(id)

            val disposable = response.subscribeOn(Schedulers.io())
                .toObservable()
                .observeOn(AndroidSchedulers.mainThread())
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