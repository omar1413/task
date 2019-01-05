package com.example.omar.manasattask.ui.base

import android.net.NetworkInfo
import android.os.Handler
import android.util.Log
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity
import com.github.pwittchen.reactivenetwork.library.rx2.ConnectivityPredicate
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

open class BasePresenter<V: MvpView>: MvpPresenter<V> {

    var mvpView: V? = null

    @Inject
    lateinit var networkConnectivityObservable: Observable<Connectivity>

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        mvpView = null
    }



    protected fun <V> checkNetwork(req: Single<V>): Observable<V> {

        if (mvpView != null && mvpView?.networkConnected() != true){
            mvpView?.showMessage("Network Not Connected")
        }


        return networkConnectivityObservable
            .filter(ConnectivityPredicate.hasState(NetworkInfo.State.CONNECTED))
            .flatMapSingle {
                req
            }
    }
}