package com.bezgrebelny.imgurgalleryapp.core.common

interface Mapper<from, to> {
    fun map(from: from): to
}