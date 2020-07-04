package com.sample.myapplication.di

import com.sample.myapplication.view.homepage.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder {

    @ContributesAndroidInjector
    abstract fun MainActivityInjector(): MainActivity

}