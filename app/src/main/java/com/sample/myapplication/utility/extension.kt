package com.sample.myapplication.utility

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.sample.myapplication.R

fun <A : AppCompatActivity> A.setToolbar(toolbar: Toolbar, title:String, homeButton:Boolean=false, homeAsUp:Boolean=false) {
    toolbar.findViewById<TextView>(R.id.title).text=title
    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(homeAsUp)
    supportActionBar?.setDisplayShowHomeEnabled(homeButton)
}