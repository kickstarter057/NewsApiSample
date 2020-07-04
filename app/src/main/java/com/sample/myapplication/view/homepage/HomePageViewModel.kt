package com.sample.myapplication.view.homepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sample.myapplication.networkManager.ApiInterface
import com.sample.myapplication.utility.LiveDataWrapper
import com.sample.myapplication.view.homepage.model.TopHeadlines

class HomePageViewModel(private val mApiInterface: ApiInterface) : ViewModel() {
    private val mApiFlag = MutableLiveData<Boolean>()
    private val mApiResponse: LiveData<LiveDataWrapper<TopHeadlines>>

    init {
        mApiResponse = Transformations.switchMap(mApiFlag) {
            makeApiCall()
        }
    }

    private fun makeApiCall(): LiveData<LiveDataWrapper<TopHeadlines>> {
        return HomePageRepo.makeTopHeadlinesCall(mApiInterface)
    }

    fun makeHeadlinesCall() {
        mApiFlag.value = true
    }

    fun observeData(): LiveData<LiveDataWrapper<TopHeadlines>> = mApiResponse
}