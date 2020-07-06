package com.bezgrebelny.imgurgalleryapp.core.model

data class GalleryCommentModel(
    val id: Int,
    val imageId: String,
    val comment: String,
    val author: String,
    val authorId: Int,
    val onAlbum: Boolean,
    val albumCover: String,
    val ups: Int,
    val downs: Int,
    val points: Int,
    val datetime: Long,
    val parentId: Int,
    val deleted: Boolean,
    val vote: Any,
    val platform: String,
    val hasAdminBadge: Boolean,
    val children: List<GalleryCommentModel>
)