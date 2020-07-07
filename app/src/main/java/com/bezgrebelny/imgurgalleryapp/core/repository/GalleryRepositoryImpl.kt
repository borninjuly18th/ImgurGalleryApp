package com.bezgrebelny.imgurgalleryapp.core.repository

import com.bezgrebelny.imgurgalleryapp.core.api.ApiGalleryService
import com.bezgrebelny.imgurgalleryapp.core.api.ApiHelper
import com.bezgrebelny.imgurgalleryapp.core.mapper.GalleryAlbumMapper
import com.bezgrebelny.imgurgalleryapp.core.mapper.GalleryCommentModelMapper
import com.bezgrebelny.imgurgalleryapp.core.mapper.GalleryImageModelMapper
import com.bezgrebelny.imgurgalleryapp.core.mapper.GalleryModelMapper

class GalleryRepositoryImpl(
    private val api: ApiGalleryService,
    private val galleryModelMapper: GalleryModelMapper,
    private val galleryAlbumMapper: GalleryAlbumMapper,
    private val galleryImageModelMapper: GalleryImageModelMapper,
    private val galleryCommentModelMapper: GalleryCommentModelMapper
) : GalleryRepository, ApiHelper() {

    override suspend fun getGallery(page: Int) = getApiResult {
        api.getGallery(page = page).data.map { galleryModelMapper.map(it) }
    }

    override suspend fun getGalleryAlbum(id: String) = getApiResult {
        galleryAlbumMapper.map(api.getGalleryAlbum(id = id).data)
    }

    override suspend fun getGalleryImage(id: String) = getApiResult {
        galleryImageModelMapper.map(api.getGalleryImage(id = id).data)
    }

    override suspend fun getGalleryComments(id: String) = getApiResult {
        api.getGalleryComments(id = id).data.map { galleryCommentModelMapper.map(it) }
    }
}