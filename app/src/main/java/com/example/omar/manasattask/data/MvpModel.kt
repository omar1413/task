package com.example.omar.manasattask.data

import com.example.omar.manasattask.data.prefs.PreferenceHelper
import com.example.omar.manasattask.data.retrofit.RetrofitHelper
import com.example.omar.manasattask.data.retrofit.pojo.persondetails.PersonDetailsResponse
import com.example.omar.manasattask.data.retrofit.pojo.personimages.PersonImagesResponse
import com.example.omar.manasattask.data.retrofit.pojo.popular.PopularRoot
import io.reactivex.Single

interface MvpModel: RetrofitHelper,PreferenceHelper