package com.bezgrebelny.imgurgalleryapp.core.api.model

import com.google.gson.annotations.SerializedName

data class Response<T>(
    @SerializedName("data") val `data`: T,
    @SerializedName("status") val status: Int,
    @SerializedName("success") val success: Boolean
)