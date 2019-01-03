package com.example.omar.manasattask.ui.details

import com.example.omar.manasattask.data.MvpModel
import com.example.omar.manasattask.ui.base.BasePresenter


class DetailsPresenter<V : DetailsMvpView> (val dataManager:MvpModel): BasePresenter<V>(),DetailsMvpPresenter<V>{



    override fun getUserDetails() {
        val id = dataManager.getUserDetailsId()
        

    }


    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        getUserDetails()
    }

}