package com.example.omar.manasattask.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.omar.manasattask.R
import com.example.omar.manasattask.ui.base.BaseActivity

class DetailsActivity : BaseActivity(),DetailsMvpView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }
}
