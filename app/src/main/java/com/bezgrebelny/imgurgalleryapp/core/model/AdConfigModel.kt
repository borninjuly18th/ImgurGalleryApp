package com.bezgrebelny.imgurgalleryapp.core.model

data class AdConfigModel(
    val safeFlags: List<String>,
    val highRiskFlags: List<Any>,
    val unsafeFlags: List<String>,
    val wallUnsafeFlags: List<Any>,
    val showsAds: Boolean
)