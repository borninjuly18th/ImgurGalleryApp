package com.bezgrebelny.imgurgalleryapp.core.datasource

import androidx.paging.PagingSource
import com.bezgrebelny.imgurgalleryapp.core.common.extentions.get
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryModel
import com.bezgrebelny.imgurgalleryapp.core.repository.GalleryRepository

class GalleryPagingSource(private val galleryRepository: GalleryRepository) :
    PagingSource<Int, GalleryModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GalleryModel> {

        val page = params.key ?: 1
        val data = galleryRepository.getGallery(page).get {
            return LoadResult.Error(it.exception)
        }

        return data?.let { LoadResult.Page(it, null, page + 1) } ?: LoadResult.Error(
            NullPointerException()
        )
    }
}