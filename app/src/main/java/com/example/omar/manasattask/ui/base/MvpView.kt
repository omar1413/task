package com.example.omar.manasattask.ui.base

import androidx.annotation.StringRes

interface MvpView {

    fun onError(message : String)
    fun onError(@StringRes resId : Int)
    fun showMessage(message: String)
    fun showMessage(@StringRes resId: Int)

    fun networkConnected():Boolean
}