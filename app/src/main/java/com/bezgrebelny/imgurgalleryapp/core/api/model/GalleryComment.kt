package com.bezgrebelny.imgurgalleryapp.core.api.model

import com.google.gson.annotations.SerializedName

data class GalleryComment(
    @SerializedName("id") val id: Int?,
    @SerializedName("image_id") val imageId: String?,
    @SerializedName("comment") val comment: String?,
    @SerializedName("author") val author: String?,
    @SerializedName("author_id") val authorId: Int?,
    @SerializedName("on_album") val onAlbum: Boolean?,
    @SerializedName("album_cover") val albumCover: String?,
    @SerializedName("ups") val ups: Int?,
    @SerializedName("downs") val downs: Int?,
    @SerializedName("points") val points: Int?,
    @SerializedName("datetime") val datetime: Long?,
    @SerializedName("parent_id") val parentId: Int?,
    @SerializedName("deleted") val deleted: Boolean?,
    @SerializedName("vote") val vote: Any?,
    @SerializedName("platform") val platform: String?,
    @SerializedName("has_admin_badge") val hasAdminBadge: Boolean?,
    @SerializedName("children") val children: List<GalleryComment>?
)