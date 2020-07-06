package com.bezgrebelny.imgurgalleryapp.core

import com.bezgrebelny.imgurgalleryapp.core.api.apiModule
import com.bezgrebelny.imgurgalleryapp.core.mapper.mapperModule
import com.bezgrebelny.imgurgalleryapp.core.repository.repositoryModule
import org.koin.core.module.Module
import org.koin.dsl.module

val coreModule: Module
    get() = module {
        apiModule()
        mapperModule()
        repositoryModule()
    }