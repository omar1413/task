package com.example.omar.manasattask.ui.main

import com.example.omar.manasattask.BuildConfig
import com.example.omar.manasattask.data.MvpModel
import com.example.omar.manasattask.models.PopularPerson
import com.example.omar.manasattask.ui.base.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PopularPersonsPresenter<V : PopularPersonsMvpView> @Inject constructor(val dataManager: MvpModel) :
    BasePresenter<V>(),
    PopularPersonsMvpPresenter<V> {


    override fun listPopularPersons() {

        val disposable = dataManager.getPopularPeopleByPage(1)
            .subscribeOn(Schedulers.io())
            .map {
                it.results
            }
            .toObservable()
            .flatMap {
                Observable.fromIterable(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { it ->
                mvpView?.addPopularPersonToTheList(
                    PopularPerson(
                        it.id, it.name,
                        it.popularity,
                        BuildConfig.Base_IMAGE_URL + it.profilePath
                    )
                )
            }

    }

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        listPopularPersons()
    }


}