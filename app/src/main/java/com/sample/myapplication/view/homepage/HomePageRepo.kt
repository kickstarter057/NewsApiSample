package com.sample.myapplication.view.homepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sample.myapplication.networkManager.ApiInterface
import com.sample.myapplication.utility.LiveDataWrapper
import com.sample.myapplication.utility.Status
import com.sample.myapplication.view.homepage.model.TopHeadlines
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

object HomePageRepo {

    fun makeTopHeadlinesCall(apiInterface: ApiInterface): LiveData<LiveDataWrapper<TopHeadlines>> {
        val model = MutableLiveData<LiveDataWrapper<TopHeadlines>>()
        apiInterface.getAddress()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : io.reactivex.Observer<TopHeadlines> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: TopHeadlines) {
                    if(t.status == "ok")
                        model.value = LiveDataWrapper.success(t,Status.S)
                }

                override fun onError(e: Throwable) {
                    model.value = LiveDataWrapper.error(null,Status.E)
                }

            })
        return model
    }
}