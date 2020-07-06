package com.bezgrebelny.imgurgalleryapp.core.mapper

import com.bezgrebelny.imgurgalleryapp.core.api.model.GalleryAlbum
import com.bezgrebelny.imgurgalleryapp.core.common.Mapper
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryAlbumModel

interface GalleryAlbumModelImageModelMapper :
    Mapper<GalleryAlbum.Image, GalleryAlbumModel.ImageModel>