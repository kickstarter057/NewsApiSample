package com.sample.myapplication.networkManager

import com.sample.myapplication.view.homepage.model.TopHeadlines
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET(TOP_HEADLINES)
    fun getAddress() : Observable<TopHeadlines>

    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
        const val TOP_HEADLINES="top-headlines?country=in&apiKey=a692ad63ec7546a898b19ba8b022dbd4"
    }

}