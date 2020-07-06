package com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.adapteritems

import android.view.View
import com.bezgrebelny.imgurgalleryapp.R
import com.bezgrebelny.imgurgalleryapp.app.common.IdModel
import com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.AdapterItem
import com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.UiModel
import com.bezgrebelny.imgurgalleryapp.app.common.extentions.setImageUrl
import kotlinx.android.synthetic.main.item_gallery.view.*

class GalleryAdapterItem(
    private var click: ((GalleryUiModel) -> Unit)?
) : AdapterItem<GalleryUiModel> {

    override val layoutRes: Int
        get() = R.layout.item_gallery

    override fun <T : UiModel> isModel(model: T): Boolean = model is GalleryUiModel

    override fun bindView(view: View, data: GalleryUiModel) {
        setImageUrl(view.iv, data.imagePath)

        view.iv.contentDescription = data.imageDesc

        view.tvUpCount.text = data.upCount
        view.tvDownCount.text = data.downCount
        view.tvCommentCount.text = data.commentCount
        view.tvViewCount.text = data.viewsCount
    }

    override fun bindClick(view: View, data: GalleryUiModel) {
        click?.also { click ->
            view.setOnClickListener {
                click.invoke(data)
            }
        }
    }

    override fun cleanUp() {
        super.cleanUp()
        click = null
    }
}

data class GalleryUiModel(
    override val id: String,
    val imagePath: String,
    val imageDesc: String,
    val upCount: String,
    val downCount: String,
    val commentCount: String,
    val viewsCount: String,
    val isAlbum: Boolean
) : UiModel, IdModel<String>