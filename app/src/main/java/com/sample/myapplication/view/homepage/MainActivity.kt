package com.sample.myapplication.view.homepage

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.myapplication.R
import com.sample.myapplication.databinding.ActivityMainBinding
import com.sample.myapplication.factory.ViewModelFactory
import com.sample.myapplication.networkManager.ApiInterface
import com.sample.myapplication.utility.Status
import com.sample.myapplication.utility.setToolbar
import com.sample.myapplication.view.homepage.adapter.HeadlinesAdapter
import com.sample.myapplication.view.homepage.model.Article
import dagger.android.support.DaggerAppCompatActivity
import java.util.ArrayList
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var mViewBinding: ActivityMainBinding
    private var mViewModel: HomePageViewModel? = null

    @Inject
    lateinit var mApiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
        makeApiCall()
        observerApi()
    }

    private fun initUI() {
        mViewBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        setToolbar(
            mViewBinding.toolbar.findViewById(R.id.toolbar), "HEADLINES",
            homeButton = false,
            homeAsUp = false
        )
        val factory = ViewModelFactory(mApiInterface)
        mViewModel = ViewModelProviders.of(this, factory).get(HomePageViewModel::class.java)
    }

    private fun makeApiCall() {
        mViewModel?.makeHeadlinesCall()
    }

    private fun observerApi() {
        mViewModel?.observeData()?.observe(this, Observer {
            if(it.status == Status.S && !it.data?.articles?.isNullOrEmpty()!!)
                setAdapterData(it.data?.articles!!)
        })
    }

    private fun setAdapterData(articles: ArrayList<Article>) {
        mViewBinding.rv.adapter = HeadlinesAdapter(articles)
        mViewBinding.rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

}
