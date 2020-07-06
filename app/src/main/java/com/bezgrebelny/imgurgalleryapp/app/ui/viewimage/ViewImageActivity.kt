package com.bezgrebelny.imgurgalleryapp.app.ui.viewimage

import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.bezgrebelny.imgurgalleryapp.R
import com.bezgrebelny.imgurgalleryapp.app.common.activity.ActivityBase
import com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.AdapterDelegate
import com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.adapteritems.CommentAdapterItem
import com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.adapteritems.CommentUiModel
import com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.adapteritems.ImageAdapterItem
import com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.adapteritems.ImageUiModel
import com.bezgrebelny.imgurgalleryapp.app.common.extentions.*
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryAlbumModel
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryImageModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_view_image.*
import org.koin.android.ext.android.inject
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf

class ViewImageActivity : ActivityBase() {

    override val di: Module
        get() = diModule
    override val vm: ViewImageVM by inject { parametersOf(getActivityContent()) }

    private lateinit var snackbar: Snackbar
    private val imageAdapter = AdapterDelegate<ImageUiModel>(ImageAdapterItem())
    private val commentAdapter = AdapterDelegate<CommentUiModel>(CommentAdapterItem())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_image)

        setupSnackbar()
        setupImageAdapter()
        setupCommentAdapter()
        setupData()
        setupEvent()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            true
        } else super.onOptionsItemSelected(item)

    private fun setupImageAdapter() {
        with(rvImages) {
            layoutManager = LinearLayoutManager(this@ViewImageActivity)
            adapter = imageAdapter
        }
    }

    private fun setupCommentAdapter() {
        with(rvComments) {
            layoutManager = LinearLayoutManager(this@ViewImageActivity)
            adapter = commentAdapter
        }
    }

    private fun setupData() {
        observe(vm.data) {
            ll.isVisible = true

            when (it) {
                is GalleryImageModel -> {
                    title = it.title
                    tvUpCount.text = it.ups.toString()
                    tvDownCount.text = it.downs.toString()
                    tvCommentCount.text = it.commentCount.toString()
                    tvViewCount.text = it.views.toString()

                    imageAdapter.dataList = listOf(ImageUiModel(1L, it.link))
                }
                is GalleryAlbumModel -> {
                    title = it.title
                    tvUpCount.text = it.ups.toString()
                    tvDownCount.text = it.downs.toString()
                    tvCommentCount.text = it.commentCount.toString()
                    tvViewCount.text = it.views.toString()

                    imageAdapter.dataList = it.images.mapIndexed { index, model ->
                        ImageUiModel(
                            index.toLong(),
                            model.link
                        )
                    }
                }
            }
        }

        observe(vm.commentList) { list ->
            commentAdapter.dataList = list.map { model ->
                val isImage = commentIsImage(model.comment)

                CommentUiModel(
                    id = model.id.toLong(),
                    authorAndPlatform = getString(
                        R.string.view_image_comment_author_format,
                        model.author,
                        model.platform
                    ),
                    points = getString(R.string.view_image_comment_pts_format, model.points),
                    hours = getString(
                        R.string.view_image_comment_hr_format,
                        getHoursPast(model.datetime)
                    ),
                    image = if (isImage) model.comment else null,
                    comment = if (isImage) null else model.comment
                )
            }
        }
    }

    private fun commentIsImage(text: String) =
        text.startsWith("https://i.imgur.com", true) || text.startsWith("http://i.imgur.com", true)

    private fun setupEvent() {
        observeEvent(vm.event) {
            progress.isVisible = it is Event.Loading && it.value
            if (it is Event.Error) snackbar.show() else {
                snackbar.dismiss()
                setupSnackbar()
            }
        }
    }

    private fun setupSnackbar() {
        snackbar = createErrorSnackbarWithAction { vm.fetchData() }
    }
}