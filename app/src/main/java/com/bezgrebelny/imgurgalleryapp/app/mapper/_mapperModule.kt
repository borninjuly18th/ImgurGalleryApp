package com.bezgrebelny.imgurgalleryapp.app.mapper

import org.koin.core.module.Module

fun Module.mapperModule() {
    single<GalleryModelToGalleryUiModel> { GalleryModelToGalleryUiModelImpl() }
}