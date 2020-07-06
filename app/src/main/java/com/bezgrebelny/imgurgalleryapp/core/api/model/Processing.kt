package com.bezgrebelny.imgurgalleryapp.core.api.model

import com.google.gson.annotations.SerializedName

data class Processing(
    @SerializedName("status") val status: String?
)