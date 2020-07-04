package com.sample.myapplication.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.myapplication.networkManager.ApiInterface
import com.sample.myapplication.view.homepage.HomePageViewModel

class ViewModelFactory(val mApiInterface: ApiInterface) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomePageViewModel(mApiInterface) as T
    }
}