package com.example.omar.manasattask.ui.main

import com.example.omar.manasattask.models.PopularPerson
import com.example.omar.manasattask.ui.base.MvpPresenter
import com.example.omar.manasattask.ui.base.MvpView

interface PopularPersonsMvpPresenter<V: PopularPersonsMvpView> :MvpPresenter<V> {

    fun listPopularPersons()

}