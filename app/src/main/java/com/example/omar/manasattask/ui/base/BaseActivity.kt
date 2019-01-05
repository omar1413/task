package com.example.omar.manasattask.ui.base

import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.omar.manasattask.TaskApp
import com.example.omar.manasattask.di.component.ActivityComponent
import com.example.omar.manasattask.di.component.DaggerActivityComponent
import com.example.omar.manasattask.di.module.ActivityModule
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity(), MvpView {


    var activityComponent: ActivityComponent? = null

    @Inject
    lateinit var connectivityManager: ConnectivityManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .appComponent((application as TaskApp).component)
            .build()

    }


    override fun onError(message: String) {
        Toast.makeText(this, "Error--" + message + "--Error", Toast.LENGTH_SHORT).show()
    }

    override fun onError(resId: Int) {
        onError(resources.getString(resId))
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(resId: Int) {
        showMessage(resources.getString(resId))
    }

    override fun networkConnected(): Boolean {
        return connectivityManager.activeNetworkInfo != null
    }


}