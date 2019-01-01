package com.example.omar.manasattask.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.omar.manasattask.R
import com.example.omar.manasattask.ui.base.BaseActivity

class PopularPersonsActivity : BaseActivity(), PopularPersonsMvpView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    
}
