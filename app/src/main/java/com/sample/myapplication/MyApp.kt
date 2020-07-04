package com.sample.myapplication

import com.sample.myapplication.di.DaggerAppComponant
import com.sample.myapplication.di.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MyApp : DaggerApplication()  {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponant.builder().networkModule(NetworkModule(this)).build()
    }
}