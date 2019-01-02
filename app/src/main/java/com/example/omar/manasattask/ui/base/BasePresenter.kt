package com.example.omar.manasattask.ui.base

open class BasePresenter<V: MvpView>: MvpPresenter<V> {

    var mvpView: V? = null

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        mvpView = null
    }
}