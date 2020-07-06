package com.bezgrebelny.imgurgalleryapp.core.mapper

import com.bezgrebelny.imgurgalleryapp.core.api.model.GalleryAlbum
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryAlbumModel

class GalleryAlbumMapperImpl(
    private val adConfigModelMapper: AdConfigModelMapper,
    private val galleryAlbumModelImageModelMapper: GalleryAlbumModelImageModelMapper
) : GalleryAlbumMapper {
    override fun map(from: GalleryAlbum): GalleryAlbumModel = GalleryAlbumModel(
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
        vote = from.vote ?: "",
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
        tags = from.tags ?: listOf(),
        adType = from.adType ?: 0,
        adUrl = from.adUrl ?: "",
        inMostViral = from.inMostViral ?: false,
        includeAlbumAds = from.includeAlbumAds ?: false,
        images = from.images?.let { list -> list.map { galleryAlbumModelImageModelMapper.map(it) } }
            ?: listOf(),
        adConfig = from.adConfig?.let { adConfigModelMapper.map(it) }
    )
}