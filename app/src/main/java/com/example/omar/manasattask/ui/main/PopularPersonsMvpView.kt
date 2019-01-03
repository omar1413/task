package com.example.omar.manasattask.ui.main

import com.example.omar.manasattask.models.PopularPerson
import com.example.omar.manasattask.ui.base.MvpView

interface PopularPersonsMvpView: MvpView {


    fun listPopularPersons(persons: List<PopularPerson>)

    fun addPopularPersonToTheList(person: PopularPerson)

    fun goToDetailsActivity()

}