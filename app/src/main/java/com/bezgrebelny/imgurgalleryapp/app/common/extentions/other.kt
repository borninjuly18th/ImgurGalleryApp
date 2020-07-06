package com.bezgrebelny.imgurgalleryapp.app.common.extentions

import android.widget.ImageView
import com.bezgrebelny.imgurgalleryapp.R
import com.bumptech.glide.Glide
import java.util.*

fun setImageUrl(view: ImageView, url: String) {
    Glide.with(view.context)
        .load(url)
        .placeholder(R.drawable.ic_image_125dp)
        .error(R.drawable.ic_broken_image_125dp)
        .into(view)
}

fun getHoursPast(time: Long): Long =
    (((Calendar.getInstance().timeInMillis / 1000) - time) / 360)

inline fun isLoading(loading: (Boolean) -> Unit, body: () -> Unit) {
    loading.invoke(true)
    body.invoke()
    loading.invoke(false)
}