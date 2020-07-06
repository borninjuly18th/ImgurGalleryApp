package com.bezgrebelny.imgurgalleryapp.core.api

import com.bezgrebelny.imgurgalleryapp.core.api.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiGalleryService {

    @GET("gallery/{section}/{sort}/{window}/{page}")
    suspend fun getGallery(
        @Path("section") section: String = "hot",
        @Path("sort") sort: String = "viral",
        @Path("window") window: String = "day",
        @Path("page") page: Int,
        @Query("showViral") showViral: Boolean = true,
        @Query("mature") mature: Boolean = false,
        @Query("album_previews") albumPreviews: Boolean = false
    ): Response<List<Gallery>>

    @GET("gallery/album/{id}")
    suspend fun getGalleryAlbum(@Path("id") id: String): Response<GalleryAlbum>

    @GET("gallery/image/{id}")
    suspend fun getGalleryImage(@Path("id") id: String): Response<GalleryImage>

    @GET("gallery/{id}/comments/{sort}")
    suspend fun getGalleryComments(
        @Path("id") id: String,
        @Path("sort") sort: String = "best"
    ): Response<List<GalleryComment>>
}