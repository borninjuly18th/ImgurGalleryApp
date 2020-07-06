package com.bezgrebelny.imgurgalleryapp.core.mapper

import com.bezgrebelny.imgurgalleryapp.core.api.model.Gallery
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryModel

class GalleryModelImageModelMapperImpl(
    private val processingModelMapper: ProcessingModelMapper
) : GalleryModelImageModelMapper {
    override fun map(from: Gallery.Image): GalleryModel.ImageModel = GalleryModel.ImageModel(
        id = from.id ?: "",
        title = from.title ?: "",
        description = from.description ?: "",
        datetime = from.datetime ?: 0,
        type = from.type ?: "",
        animated = from.animated ?: false,
        width = from.width ?: 0,
        height = from.height ?: 0,
        size = from.size ?: 0,
        views = from.views ?: 0,
        bandwidth = from.bandwidth ?: 0,
        vote = from.vote ?: "",
        favorite = from.favorite ?: false,
        nsfw = from.nsfw ?: "",
        section = from.section ?: "",
        accountUrl = from.accountUrl ?: "",
        accountId = from.accountId ?: "",
        isAd = from.isAd ?: false,
        inMostViral = from.inMostViral ?: false,
        hasSound = from.hasSound ?: false,
        tags = from.tags ?: listOf(),
        adType = from.adType ?: 0,
        adUrl = from.adUrl ?: "",
        edited = from.edited ?: "",
        inGallery = from.inGallery ?: false,
        link = from.link ?: "",
        commentCount = from.commentCount ?: "",
        favoriteCount = from.favoriteCount ?: "",
        ups = from.ups ?: "",
        downs = from.downs ?: "",
        points = from.points ?: "",
        score = from.score ?: "",
        mp4Size = from.mp4Size ?: 0,
        mp4 = from.mp4 ?: "",
        gifv = from.gifv ?: "",
        hls = from.hls ?: "",
        processing = from.processing?.let { processingModelMapper.map(it) }
    )
}