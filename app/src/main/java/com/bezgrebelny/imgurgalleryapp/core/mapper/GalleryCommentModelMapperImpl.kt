package com.bezgrebelny.imgurgalleryapp.core.mapper

import com.bezgrebelny.imgurgalleryapp.core.api.model.GalleryComment
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryCommentModel

class GalleryCommentModelMapperImpl : GalleryCommentModelMapper {
    override fun map(from: GalleryComment): GalleryCommentModel = GalleryCommentModel(
        id = from.id ?: 0,
        imageId = from.imageId ?: "",
        comment = from.comment ?: "",
        author = from.author ?: "",
        authorId = from.authorId ?: 0,
        onAlbum = from.onAlbum ?: false,
        albumCover = from.albumCover ?: "",
        ups = from.ups ?: 0,
        downs = from.downs ?: 0,
        points = from.points ?: 0,
        datetime = from.datetime ?: 0,
        parentId = from.parentId ?: 0,
        deleted = from.deleted ?: false,
        vote = from.vote ?: "",
        platform = from.platform ?: "",
        hasAdminBadge = from.hasAdminBadge ?: false,
        children = from.children?.let { list -> list.map { map(it) } } ?: listOf()
    )
}