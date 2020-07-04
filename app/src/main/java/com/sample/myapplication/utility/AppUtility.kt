package com.sample.myapplication.utility

import android.content.Context
import android.content.res.Resources

object AppUtility {
    fun getScreenWidth() : Int {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
}