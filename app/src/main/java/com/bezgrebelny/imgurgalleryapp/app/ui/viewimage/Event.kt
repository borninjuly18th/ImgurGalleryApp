package com.bezgrebelny.imgurgalleryapp.app.ui.viewimage

sealed class Event {
    data class Loading(val value: Boolean) : Event()
    object Error : Event()
}