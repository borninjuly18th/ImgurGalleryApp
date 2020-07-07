package com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.bezgrebelny.imgurgalleryapp.app.common.IdModel

class AdapterDelegatePaged<U, T>(vararg delegateItem: AdapterItem<*>) :
    PagingDataAdapter<U, ViewHolder<U>>(getDiffUtil()) where U : UiModel, U : IdModel<T> {

    private val adapterManager = AdapterManager<U>(*delegateItem)

    override fun getItemViewType(position: Int): Int =
        getItem(position)
            ?.let { adapterManager.getItemViewType(it) }
            ?: super.getItemViewType(position)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<U> =
        adapterManager.onCreateViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder<U>, position: Int) {
        getItem(position)?.let { adapterManager.onBindViewHolder(holder, it) }
    }

    fun cleanUp() {
        adapterManager.cleanUp()
    }

    companion object {
        private fun <T, U : IdModel<T>> getDiffUtil() = object : DiffUtil.ItemCallback<U>() {

            override fun areItemsTheSame(oldItem: U, newItem: U): Boolean = oldItem.id == newItem.id

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: U, newItem: U): Boolean = oldItem == newItem
        }
    }
}