package com.bezgrebelny.imgurgalleryapp.core.api.model

import com.google.gson.annotations.SerializedName

data class AdConfig(
    @SerializedName("safeFlags") val safeFlags: List<String>?,
    @SerializedName("highRiskFlags") val highRiskFlags: List<Any>?,
    @SerializedName("unsafeFlags") val unsafeFlags: List<String>?,
    @SerializedName("wallUnsafeFlags") val wallUnsafeFlags: List<Any>?,
    @SerializedName("showsAds") val showsAds: Boolean?
)