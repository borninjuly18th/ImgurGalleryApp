package com.bezgrebelny.imgurgalleryapp.app.ui.gallery

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bezgrebelny.imgurgalleryapp.R
import com.bezgrebelny.imgurgalleryapp.app.common.activity.ActivityBase
import com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.AdapterDelegatePaged
import com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.adapteritems.GalleryAdapterItem
import com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.adapteritems.GalleryUiModel
import com.bezgrebelny.imgurgalleryapp.app.common.extentions.createErrorSnackbarWithAction
import com.bezgrebelny.imgurgalleryapp.app.common.extentions.navigateTo
import com.bezgrebelny.imgurgalleryapp.app.ui.viewimage.ViewImageActivity
import com.bezgrebelny.imgurgalleryapp.app.ui.viewimage.ViewImageContent
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_gallery.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.module.Module

class GalleryActivity : ActivityBase() {

    override val di: Module
        get() = diModule
    override val vm: GalleryVM by viewModel()

    private lateinit var snackbar: Snackbar
    private val _adapter = AdapterDelegatePaged<GalleryUiModel, String>(
        GalleryAdapterItem {
            navigateTo<ViewImageActivity>(ViewImageContent(it.id, it.isAlbum))
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        setupSnackbar()
        setupAdapter()
        setupData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.gallery_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        if (item.itemId == R.id.gallery_update) {
            _adapter.refresh()
            true
        } else super.onOptionsItemSelected(item)

    private fun setupSnackbar() {
        snackbar = createErrorSnackbarWithAction { _adapter.refresh() }
    }

    private fun setupAdapter() {
        _adapter.addLoadStateListener {
            progress.isVisible = it.refresh is LoadState.Loading

            if (it.refresh is LoadState.Error) snackbar.show()
            else {
                snackbar.dismiss()
                setupSnackbar()
            }
        }

        with(rv) {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = _adapter
            setHasFixedSize(true)
        }
    }

    private fun setupData() {
        lifecycleScope.launch {
            vm.flow.collectLatest { data ->
                _adapter.submitData(data)
            }
        }
    }
}