package com.bezgrebelny.imgurgalleryapp.app.common.extentions

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.bezgrebelny.imgurgalleryapp.app.common.SingleEvent
import com.bezgrebelny.imgurgalleryapp.app.common.SingleEventObserver

inline fun <T> AppCompatActivity.observe(data: LiveData<T>, crossinline body: (T) -> Unit) {
    data.observe(this, Observer {
        if (it != null) body.invoke(it)
    })
}

inline fun <T> AppCompatActivity.observeEvent(
    data: LiveData<SingleEvent<T>>,
    crossinline body: (T) -> Unit
) {
    data.observe(this,
        SingleEventObserver {
            body.invoke(it)
        })
}