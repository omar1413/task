package com.example.omar.manasattask.utils

import android.content.Context


class Utils {
    companion object {

        fun calculateNoOfColumns(context: Context): Int {
            val displayMetrics = context.getResources().getDisplayMetrics()
            val dpWidth = displayMetrics.widthPixels / displayMetrics.density
            return (dpWidth / 180).toInt()
        }

    }
}