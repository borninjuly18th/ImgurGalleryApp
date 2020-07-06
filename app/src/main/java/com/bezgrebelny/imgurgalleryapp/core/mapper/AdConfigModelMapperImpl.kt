package com.bezgrebelny.imgurgalleryapp.core.mapper

import com.bezgrebelny.imgurgalleryapp.core.api.model.AdConfig
import com.bezgrebelny.imgurgalleryapp.core.model.AdConfigModel

class AdConfigModelMapperImpl : AdConfigModelMapper {
    override fun map(from: AdConfig): AdConfigModel = AdConfigModel(
        safeFlags = from.safeFlags ?: listOf(),
        highRiskFlags = from.highRiskFlags ?: listOf(),
        unsafeFlags = from.unsafeFlags ?: listOf(),
        wallUnsafeFlags = from.wallUnsafeFlags ?: listOf(),
        showsAds = from.showsAds ?: false
    )
}