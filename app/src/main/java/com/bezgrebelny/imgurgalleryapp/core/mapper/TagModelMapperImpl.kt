package com.bezgrebelny.imgurgalleryapp.core.mapper

import com.bezgrebelny.imgurgalleryapp.core.api.model.Tag
import com.bezgrebelny.imgurgalleryapp.core.model.TagModel

class TagModelMapperImpl(
    private val descriptionAnnotationsModelMapper: DescriptionAnnotationsModelMapper
) : TagModelMapper {
    override fun map(from: Tag): TagModel = TagModel(
        name = from.name ?: "",
        displayName = from.displayName ?: "",
        followers = from.followers ?: 0,
        totalItems = from.totalItems ?: 0,
        following = from.following ?: false,
        isWhitelisted = from.isWhitelisted ?: false,
        backgroundHash = from.backgroundHash ?: "",
        thumbnailHash = from.thumbnailHash ?: "",
        accent = from.accent ?: "",
        backgroundIsAnimated = from.backgroundIsAnimated ?: false,
        thumbnailIsAnimated = from.thumbnailIsAnimated ?: false,
        isPromoted = from.isPromoted ?: false,
        description = from.description ?: "",
        logoHash = from.logoHash ?: "",
        logoDestinationUrl = from.logoDestinationUrl ?: "",
        descriptionAnnotations = from.descriptionAnnotations?.let {
            descriptionAnnotationsModelMapper.map(it)
        }
    )
}