package com.bezgrebelny.imgurgalleryapp.app.common.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bezgrebelny.imgurgalleryapp.app.common.SingleEvent

abstract class EventViewModel<E> : ViewModel() {
    private val _event = MutableLiveData<SingleEvent<E>>()
    val event: LiveData<SingleEvent<E>>
        get() = _event

    fun setEvent(event: E) {
        _event.value = SingleEvent(event)
    }
}