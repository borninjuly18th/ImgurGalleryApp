package com.bezgrebelny.imgurgalleryapp.app.common.extentions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.bezgrebelny.imgurgalleryapp.R
import com.google.android.material.snackbar.Snackbar

fun Activity.getView(): View = window.decorView.rootView

fun Activity.createErrorSnackbarWithAction(retry: () -> Unit) =
    Snackbar.make(getView(), R.string.gallery_error_message, Snackbar.LENGTH_INDEFINITE)
        .setAction(R.string.snackbar_retry) { retry() }

// navigation
inline fun <reified T : FragmentActivity> Context.navigateTo(data: Parcelable? = null) {
    val intent = Intent(this, T::class.java)
    if (data != null) intent.putExtra(T::class.java.name, data)
    startActivity(intent)
}

fun <R : Parcelable> FragmentActivity.getActivityContent(): R? =
    intent.getParcelableExtra(this::class.java.name)