package com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.adapteritems

import android.view.View
import com.bezgrebelny.imgurgalleryapp.R
import com.bezgrebelny.imgurgalleryapp.app.common.IdModel
import com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.AdapterItem
import com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.UiModel
import com.bezgrebelny.imgurgalleryapp.app.common.extentions.setImageUrl
import kotlinx.android.synthetic.main.item_image.view.*

class ImageAdapterItem : AdapterItem<ImageUiModel> {

    override val layoutRes: Int
        get() = R.layout.item_image

    override fun <T : UiModel> isModel(model: T): Boolean = model is ImageUiModel

    override fun bindView(view: View, data: ImageUiModel) {
        setImageUrl(view.iv, data.image)
    }

    override fun bindClick(view: View, data: ImageUiModel) = Unit
}

data class ImageUiModel(
    override val id: Long,
    val image: String
) : UiModel, IdModel<Long>