package com.bezgrebelny.imgurgalleryapp.app.ui.viewimage

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val diModule: Module
    get() = module(override = true) {
        viewModel { (content: ViewImageContent) ->
            ViewImageVM(content = content, galleryRepository = get())
        }
    }