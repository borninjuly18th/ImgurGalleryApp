package com.bezgrebelny.imgurgalleryapp.core.mapper

import com.bezgrebelny.imgurgalleryapp.core.api.model.Processing
import com.bezgrebelny.imgurgalleryapp.core.model.ProcessingModel

class ProcessingModelMapperImpl : ProcessingModelMapper {
    override fun map(from: Processing): ProcessingModel = ProcessingModel(
        status = from.status ?: ""
    )
}