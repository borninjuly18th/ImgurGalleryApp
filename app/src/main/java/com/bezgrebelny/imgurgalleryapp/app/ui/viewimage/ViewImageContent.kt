package com.bezgrebelny.imgurgalleryapp.app.ui.viewimage

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ViewImageContent(
    val id: String,
    val isAlbum: Boolean
) : Parcelable