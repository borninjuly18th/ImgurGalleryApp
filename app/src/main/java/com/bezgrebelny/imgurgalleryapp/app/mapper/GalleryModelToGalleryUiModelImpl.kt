package com.bezgrebelny.imgurgalleryapp.app.mapper

import com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.adapteritems.GalleryUiModel
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryModel

class GalleryModelToGalleryUiModelImpl : GalleryModelToGalleryUiModel {
    override fun map(from: GalleryModel): GalleryUiModel = GalleryUiModel(
        id = from.id,
        imagePath = from.images.firstOrNull()?.link ?: "",
        imageDesc = from.description,
        upCount = from.ups.toString(),
        downCount = from.downs.toString(),
        commentCount = from.commentCount.toString(),
        viewsCount = from.views.toString(),
        isAlbum = from.isAlbum
    )
}