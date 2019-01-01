package com.example.omar.manasattask.ui.base

interface MvpPresenter <V: MvpView> {

    fun onAttach(mvpView: V)
    fun onDetach()
}