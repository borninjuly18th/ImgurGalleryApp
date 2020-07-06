package com.bezgrebelny.imgurgalleryapp.app.mapper

import com.bezgrebelny.imgurgalleryapp.app.common.delegateadapter.adapteritems.GalleryUiModel
import com.bezgrebelny.imgurgalleryapp.core.common.Mapper
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryModel

interface GalleryModelToGalleryUiModel : Mapper<GalleryModel, GalleryUiModel>