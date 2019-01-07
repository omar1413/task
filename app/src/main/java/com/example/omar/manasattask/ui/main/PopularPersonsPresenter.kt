package com.example.omar.manasattask.ui.main

import android.util.Log
import com.example.omar.manasattask.BuildConfig
import com.example.omar.manasattask.data.MvpModel
import com.example.omar.manasattask.data.retrofit.pojo.popular.PopularRoot
import com.example.omar.manasattask.models.PopularPerson
import com.example.omar.manasattask.ui.base.BasePresenter
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PopularPersonsPresenter<V : PopularPersonsMvpView> @Inject constructor(val dataManager: MvpModel) :
    BasePresenter<V>(),
    PopularPersonsMvpPresenter<V> {




    override fun listPopularPersons() {

        if (mvpView != null) {
            mvpView?.clearList()
        }

        val disposable = listPopularPeople(dataManager.getPopularPeopleByPage(1))


    }

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        listPopularPersons()
    }


    override fun onItemClicked(personId: Int) {
        dataManager.setUserDetailsId(personId)
        if (mvpView != null) {
            mvpView?.goToDetailsActivity()
        }
    }

    override fun searchForPerson(query: String) {
        val response = dataManager.getPerson(query, 1)
        if (mvpView != null) {
            mvpView?.clearList()
        }
        listPopularPeople(response)
    }

    private fun listPopularPeople(req: Single<PopularRoot>): Disposable? {
        networkDisposable=  checkNetwork(req)
            .subscribeOn(Schedulers.io())
            .map {
                it.results
            }
            .flatMap {
                Observable.fromIterable(it)
            }
            .doOnError {
                Log.d("", "")
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                if (mvpView == null)
                    return@subscribe
                mvpView?.addPopularPersonToTheList(
                    PopularPerson(
                        it.id, it.name,
                        it.popularity,
                        BuildConfig.Base_IMAGE_URL + it.profilePath
                    )
                )
            },{
                Log.d("", "")
            })
        return networkDisposable
    }




}