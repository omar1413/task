package com.example.omar.manasattask.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.omar.manasattask.BuildConfig
import com.example.omar.manasattask.R
import com.example.omar.manasattask.data.retrofit.pojo.persondetails.PersonDetailsResponse
import com.example.omar.manasattask.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject

class DetailsActivity : BaseActivity(),DetailsMvpView {

    @Inject
    lateinit var  presenter:DetailsMvpPresenter<DetailsMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        activityComponent?.inject(this)
    }



    override fun fillData(personDetails: PersonDetailsResponse) {
        Glide.with(this).load(BuildConfig.Base_IMAGE_URL + personDetails.profilePath).into(profile_image)
    }
}
