package com.bezgrebelny.imgurgalleryapp.core.mapper

import com.bezgrebelny.imgurgalleryapp.core.api.model.DescriptionAnnotations
import com.bezgrebelny.imgurgalleryapp.core.model.DescriptionAnnotationsModel

class DescriptionAnnotationsModelMapperImpl : DescriptionAnnotationsModelMapper {
    override fun map(from: DescriptionAnnotations): DescriptionAnnotationsModel =
        DescriptionAnnotationsModel()
}