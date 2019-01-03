package com.example.omar.manasattask.ui.main

import com.example.omar.manasattask.data.MvpModel
import com.example.omar.manasattask.data.retrofit.pojo.popular.PopularResult
import com.example.omar.manasattask.models.PopularPerson
import com.example.omar.manasattask.ui.base.BasePresenter
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.SingleSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class PopularPersonsPresenter<V : PopularPersonsMvpView> @Inject constructor(val dataManager: MvpModel) : BasePresenter<V>(),
    PopularPersonsMvpPresenter<V> {


    override fun listPopularPersons() {

        val disposable = dataManager.getPopularPeopleByPage(1)
//            .map {
//                it.results
//            }
//            .flatMapObservable {
//                Observable.fromIterable(it)
//            }
            .subscribeOn(Schedulers.io())
            .toObservable()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it ->
                //mvpView?.addPopularPersonToTheList(PopularPerson(it.id,it.name,it.popularity,it.profilePath))
            }

    }

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        listPopularPersons()
    }


}