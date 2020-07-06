package com.bezgrebelny.imgurgalleryapp.app.ui.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.bezgrebelny.imgurgalleryapp.app.mapper.GalleryModelToGalleryUiModel
import com.bezgrebelny.imgurgalleryapp.core.datasource.GalleryPagingSource
import com.bezgrebelny.imgurgalleryapp.core.repository.GalleryRepository
import kotlinx.coroutines.flow.map

class GalleryVM(
    galleryRepository: GalleryRepository,
    private val galleryModelToGalleryUiModel: GalleryModelToGalleryUiModel
) : ViewModel() {

    val flow =
        Pager(PagingConfig(pageSize = 10)) { GalleryPagingSource(galleryRepository) }.flow.map { pagingData ->
            pagingData.map { galleryModelToGalleryUiModel.map(it) }
        }.cachedIn(viewModelScope)
}