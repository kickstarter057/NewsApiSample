package com.sample.myapplication.utility

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(img: ImageView, url: String?) {
        Glide.with(img.context.applicationContext)
            .load(url)
            .fitCenter()
            .centerCrop()
            .thumbnail(.1f)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(img)
    }
}