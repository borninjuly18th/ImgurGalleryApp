package com.bezgrebelny.imgurgalleryapp.core.mapper

import com.bezgrebelny.imgurgalleryapp.core.api.model.Gallery
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryModel

class GalleryModelMapperImpl(
    private val tagModelMapper: TagModelMapper,
    private val galleryModelImageModelMapper: GalleryModelImageModelMapper,
    private val adConfigModelMapper: AdConfigModelMapper,
    private val processingModelMapper: ProcessingModelMapper
) : GalleryModelMapper {
    override fun map(from: Gallery): GalleryModel = GalleryModel(
        id = from.id ?: "",
        title = from.title ?: "",
        description = from.description ?: "",
        datetime = from.datetime ?: 0,
        cover = from.cover ?: "",
        coverWidth = from.coverWidth ?: 0,
        coverHeight = from.coverHeight ?: 0,
        accountUrl = from.accountUrl ?: "",
        accountId = from.accountId ?: 0,
        privacy = from.privacy ?: "",
        layout = from.layout ?: "",
        views = from.views ?: 0,
        link = from.link ?: "",
        ups = from.ups ?: 0,
        downs = from.downs ?: 0,
        points = from.points ?: 0,
        score = from.score ?: 0,
        isAlbum = from.isAlbum ?: false,
        vote = from.vote ?: false,
        favorite = from.favorite ?: false,
        nsfw = from.nsfw ?: false,
        section = from.section ?: "",
        commentCount = from.commentCount ?: 0,
        favoriteCount = from.favoriteCount ?: 0,
        topic = from.topic ?: "",
        topicId = from.topicId ?: 0,
        imagesCount = from.imagesCount ?: 0,
        inGallery = from.inGallery ?: false,
        isAd = from.isAd ?: false,
        tags = from.tags?.let { list -> list.map { tagModelMapper.map(it) } } ?: listOf(),
        adType = from.adType ?: 0,
        adUrl = from.adUrl ?: "",
        inMostViral = from.inMostViral ?: false,
        includeAlbumAds = from.includeAlbumAds ?: false,
        images = from.images?.let { list -> list.map { galleryModelImageModelMapper.map(it) } }
            ?: listOf(),
        adConfig = from.adConfig?.let { adConfigModelMapper.map(it) },
        type = from.type ?: "",
        animated = from.animated ?: false,
        width = from.width ?: 0,
        height = from.height ?: 0,
        size = from.size ?: 0,
        bandwidth = from.bandwidth ?: 0,
        hasSound = from.hasSound ?: false,
        edited = from.edited ?: 0,
        mp4 = from.mp4 ?: "",
        gifv = from.gifv ?: "",
        hls = from.hls ?: "",
        mp4Size = from.mp4Size ?: 0,
        looping = from.looping ?: false,
        processing = from.processing?.let { processingModelMapper.map(it) }
    )
}