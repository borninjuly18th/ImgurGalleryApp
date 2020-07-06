package com.bezgrebelny.imgurgalleryapp.app

import com.bezgrebelny.imgurgalleryapp.app.mapper.mapperModule
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module
    get() = module {
        mapperModule()
    }