package com.sample.myapplication.view.homepage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.sample.myapplication.databinding.NewsSingleRvLytBinding
import com.sample.myapplication.utility.AppUtility
import com.sample.myapplication.view.homepage.model.Article

class HeadlinesAdapter(private val mList:ArrayList<Article>) : RecyclerView.Adapter<HeadlinesAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = NewsSingleRvLytBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.binding.data = mList.get(position)
        holder.binding.executePendingBindings()
    }

    class MyHolder(val binding: NewsSingleRvLytBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.img.layoutParams = FrameLayout.LayoutParams(AppUtility.getScreenWidth(),AppUtility.getScreenWidth()/2)
        }
    }

}