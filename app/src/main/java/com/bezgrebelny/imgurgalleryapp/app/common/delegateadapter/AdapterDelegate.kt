package com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bezgrebelny.imgurgalleryapp.app.common.IdModel

class AdapterDelegate<U>(vararg delegateItem: AdapterItem<*>) :
    RecyclerView.Adapter<ViewHolder<U>>() where U : UiModel, U : IdModel<Long> {

    private val adapterManager = AdapterManager<U>(*delegateItem)

    var dataList: List<U> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    init {
        this.setHasStableIds(true)
    }

    override fun getItemCount(): Int = dataList.size

    override fun getItemId(position: Int): Long = dataList[position].id

    override fun getItemViewType(position: Int): Int =
        adapterManager.getItemViewType(dataList[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<U> =
        adapterManager.onCreateViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder<U>, position: Int) {
        adapterManager.onBindViewHolder(holder, dataList[position])
    }

    fun cleanUp() {
        adapterManager.cleanUp()
    }
}