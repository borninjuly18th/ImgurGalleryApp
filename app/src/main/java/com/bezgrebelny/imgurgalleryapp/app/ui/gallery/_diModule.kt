package com.bezgrebelny.imgurgalleryapp.app.ui.gallery

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val diModule: Module
    get() = module(override = true) {
        viewModel {
            GalleryVM(
                galleryRepository = get(),
                galleryModelToGalleryUiModel = get()
            )
        }
    }