package com.example.omar.manasattask.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity(), MvpView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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


}