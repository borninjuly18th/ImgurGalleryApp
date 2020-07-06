package com.bezgrebelny.imgurgalleryapp.core.mapper

import com.bezgrebelny.imgurgalleryapp.core.api.model.GalleryImage
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryImageModel

class GalleryImageModelMapperImpl(
    private val tagModelMapper: TagModelMapper,
    private val adConfigModelMapper: AdConfigModelMapper
) : GalleryImageModelMapper {
    override fun map(from: GalleryImage): GalleryImageModel = GalleryImageModel(
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
        nsfw = from.nsfw ?: false,
        section = from.section ?: "",
        accountUrl = from.accountUrl ?: "",
        accountId = from.accountId ?: 0,
        isAd = from.isAd ?: false,
        inMostViral = from.inMostViral ?: false,
        hasSound = from.hasSound ?: false,
        tags = from.tags?.let { list -> list.map { tagModelMapper.map(it) } } ?: listOf(),
        adType = from.adType ?: 0,
        adUrl = from.adUrl ?: "",
        edited = from.edited ?: 0,
        inGallery = from.inGallery ?: false,
        topic = from.topic ?: "",
        topicId = from.topicId ?: 0,
        link = from.link ?: "",
        adConfig = from.adConfig?.let { adConfigModelMapper.map(it) },
        commentCount = from.commentCount ?: 0,
        favoriteCount = from.favoriteCount ?: 0,
        ups = from.ups ?: 0,
        downs = from.downs ?: 0,
        points = from.points ?: 0,
        score = from.score ?: 0,
        isAlbum = from.isAlbum ?: false
    )
}