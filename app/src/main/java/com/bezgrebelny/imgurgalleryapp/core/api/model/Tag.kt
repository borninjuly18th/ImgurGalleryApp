package com.bezgrebelny.imgurgalleryapp.core.api.model

import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("name") val name: String?,
    @SerializedName("display_name") val displayName: String?,
    @SerializedName("followers") val followers: Int?,
    @SerializedName("total_items") val totalItems: Int?,
    @SerializedName("following") val following: Boolean?,
    @SerializedName("is_whitelisted") val isWhitelisted: Boolean?,
    @SerializedName("background_hash") val backgroundHash: String?,
    @SerializedName("thumbnail_hash") val thumbnailHash: Any?,
    @SerializedName("accent") val accent: String?,
    @SerializedName("background_is_animated") val backgroundIsAnimated: Boolean?,
    @SerializedName("thumbnail_is_animated") val thumbnailIsAnimated: Boolean?,
    @SerializedName("is_promoted") val isPromoted: Boolean?,
    @SerializedName("description") val description: String?,
    @SerializedName("logo_hash") val logoHash: Any?,
    @SerializedName("logo_destination_url") val logoDestinationUrl: Any?,
    @SerializedName("description_annotations") val descriptionAnnotations: DescriptionAnnotations?
)