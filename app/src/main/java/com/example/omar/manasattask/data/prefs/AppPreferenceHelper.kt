package com.example.omar.manasattask.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.example.omar.manasattask.di.qualifier.AppContextQualifier
import com.example.omar.manasattask.di.qualifier.PrefInfoQualifier
import javax.inject.Inject

class AppPreferenceHelper @Inject constructor(@AppContextQualifier val context: Context, @PrefInfoQualifier val prefFileName: String): PreferenceHelper{


    var prefs:SharedPreferences? = null

    init {
        prefs = context.getSharedPreferences(prefFileName,Context.MODE_PRIVATE)
    }


    companion object {
        val USER_DETAILS_ID = "USER_DETAILS_ID"
    }


    override fun setUserDetailsId(id: Int) {
        prefs?.edit()?.putInt(USER_DETAILS_ID, id)?.apply()
    }

    override fun getUserDetailsId():Int? {
        val id= prefs?.getInt(USER_DETAILS_ID,-1)
        if (id == -1)
            return null
        return id
    }


}