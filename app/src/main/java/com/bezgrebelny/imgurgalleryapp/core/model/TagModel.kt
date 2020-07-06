package com.bezgrebelny.imgurgalleryapp.core.model

data class TagModel(
    val name: String,
    val displayName: String,
    val followers: Int,
    val totalItems: Int,
    val following: Boolean,
    val isWhitelisted: Boolean,
    val backgroundHash: String,
    val thumbnailHash: Any,
    val accent: String,
    val backgroundIsAnimated: Boolean,
    val thumbnailIsAnimated: Boolean,
    val isPromoted: Boolean,
    val description: String,
    val logoHash: Any,
    val logoDestinationUrl: Any,
    val descriptionAnnotations: DescriptionAnnotationsModel?
)