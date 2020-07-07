package com.bezgrebelny.imgurgalleryapp.core.repository

import com.bezgrebelny.imgurgalleryapp.core.api.ApiHelper
import com.bezgrebelny.imgurgalleryapp.core.common.extentions.ApiResult
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryAlbumModel
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryCommentModel
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryImageModel
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryModel

interface GalleryRepository {
    suspend fun getGallery(page: Int): ApiResult<List<GalleryModel>, ApiHelper.ApiError>
    suspend fun getGalleryAlbum(id: String): ApiResult<GalleryAlbumModel, ApiHelper.ApiError>
    suspend fun getGalleryImage(id: String): ApiResult<GalleryImageModel, ApiHelper.ApiError>
    suspend fun getGalleryComments(id: String): ApiResult<List<GalleryCommentModel>, ApiHelper.ApiError>
}