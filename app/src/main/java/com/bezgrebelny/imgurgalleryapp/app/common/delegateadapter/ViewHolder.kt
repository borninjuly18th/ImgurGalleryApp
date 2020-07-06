package com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ViewHolder<U : UiModel>(
    view: View,
    private val currentAdapter: AdapterItem<U>
) : RecyclerView.ViewHolder(view) {

    lateinit var model: U

    fun bindClick() {
        currentAdapter.bindClick(itemView, model)
    }
}