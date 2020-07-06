package com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.adapteritems

import android.view.View
import androidx.core.view.isVisible
import com.bezgrebelny.imgurgalleryapp.R
import com.bezgrebelny.imgurgalleryapp.app.common.IdModel
import com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.AdapterItem
import com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.UiModel
import com.bezgrebelny.imgurgalleryapp.app.common.extentions.setImageUrl
import kotlinx.android.synthetic.main.item_comment.view.*

class CommentAdapterItem : AdapterItem<CommentUiModel> {

    override val layoutRes: Int
        get() = R.layout.item_comment

    override fun <T : UiModel> isModel(model: T): Boolean = model is CommentUiModel

    override fun bindView(view: View, data: CommentUiModel) {
        with(view) {
            tvAuthorAndPlatform.text = data.authorAndPlatform
            tvPoints.text = data.points
            tvHours.text = data.hours

            iv.isVisible = data.image != null
            if (data.image != null) {
                setImageUrl(iv, data.image)
            }

            tvComment.isVisible = data.comment != null
            tvComment.text = data.comment
        }
    }

    override fun bindClick(view: View, data: CommentUiModel) {
    }
}

data class CommentUiModel(
    override val id: Long,
    val authorAndPlatform: String,
    val points: String,
    val hours: String,
    val image: String?,
    val comment: String?
) : UiModel, IdModel<Long>