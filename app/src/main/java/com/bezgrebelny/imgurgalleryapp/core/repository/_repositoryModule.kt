package com.bezgrebelny.imgurgalleryapp.core.repository

import org.koin.core.module.Module

fun Module.repositoryModule() {
    single<GalleryRepository> {
        GalleryRepositoryImpl(
            api = get(),
            galleryAlbumMapper = get(),
            galleryCommentModelMapper = get(),
            galleryImageModelMapper = get(),
            galleryModelMapper = get()
        )
    }
}