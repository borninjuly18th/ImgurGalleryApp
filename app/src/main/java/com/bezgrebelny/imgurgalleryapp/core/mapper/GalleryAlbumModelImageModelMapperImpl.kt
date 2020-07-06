package com.bezgrebelny.imgurgalleryapp.core.mapper

import com.bezgrebelny.imgurgalleryapp.core.api.model.GalleryAlbum
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryAlbumModel

class GalleryAlbumModelImageModelMapperImpl : GalleryAlbumModelImageModelMapper {
    override fun map(from: GalleryAlbum.Image): GalleryAlbumModel.ImageModel =
        GalleryAlbumModel.ImageModel(
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
            score = from.score ?: ""
        )
}