package com.bezgrebelny.imgurgalleryapp.core.mapper

import org.koin.core.module.Module

fun Module.mapperModule() {
    single<AdConfigModelMapper> { AdConfigModelMapperImpl() }
    single<DescriptionAnnotationsModelMapper> { DescriptionAnnotationsModelMapperImpl() }
    single<GalleryAlbumMapper> {
        GalleryAlbumMapperImpl(
            adConfigModelMapper = get(),
            galleryAlbumModelImageModelMapper = get()
        )
    }
    single<GalleryAlbumModelImageModelMapper> { GalleryAlbumModelImageModelMapperImpl() }
    single<GalleryCommentModelMapper> { GalleryCommentModelMapperImpl() }
    single<GalleryImageModelMapper> {
        GalleryImageModelMapperImpl(
            adConfigModelMapper = get(),
            tagModelMapper = get()
        )
    }
    single<GalleryModelImageModelMapper> {
        GalleryModelImageModelMapperImpl(
            processingModelMapper = get()
        )
    }
    single<GalleryModelMapper> {
        GalleryModelMapperImpl(
            adConfigModelMapper = get(),
            processingModelMapper = get(),
            tagModelMapper = get(),
            galleryModelImageModelMapper = get()
        )
    }
    single<ProcessingModelMapper> { ProcessingModelMapperImpl() }
    single<TagModelMapper> { TagModelMapperImpl(descriptionAnnotationsModelMapper = get()) }
}