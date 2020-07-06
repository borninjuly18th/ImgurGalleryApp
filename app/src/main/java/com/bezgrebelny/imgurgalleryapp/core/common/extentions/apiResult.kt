package com.bezgrebelny.imgurgalleryapp.core.common.extentions

sealed class ApiResult<T, E> {
    data class Success<T, E>(val data: T) : ApiResult<T, E>()
    data class Error<T, E>(val error: E, val exception: Exception) : ApiResult<T, E>()
}

inline fun <R, E> ApiResult<R, E>?.get(errorBody: (ApiResult.Error<R, E>) -> Unit): R? =
    when (this) {
        is ApiResult.Success -> data
        is ApiResult.Error -> {
            errorBody(this)
            null
        }
        else -> null
    }

inline fun <R, E> ApiResult<R, E>?.process(successBody: (R) -> Unit, errorBody: (E) -> Unit) {
    when (this) {
        is ApiResult.Success<R, E> -> successBody(data)
        is ApiResult.Error<R, E> -> errorBody(error)
    }
}