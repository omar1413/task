package com.example.omar.manasattask.data.prefs

import android.content.Context
import android.content.SharedPreferences

class AppPreferenceHelper constructor(val context: Context, val prefFileName: String): PreferenceHelper{


    var prefs:SharedPreferences? = null

    init {
        prefs = context.getSharedPreferences(prefFileName,Context.MODE_PRIVATE)
    }


    companion object {
        val USER_DETAILS_ID = "USER_DETAILS_ID"
    }


    override fun setUserDetailsId(id: Int) {
        prefs?.edit()?.putInt(USER_DETAILS_ID, id)
    }

    override fun getUserDetailsId():Int? {
        val id= prefs?.getInt(USER_DETAILS_ID,-1)
        if (id == -1)
            return null
        return id
    }


}