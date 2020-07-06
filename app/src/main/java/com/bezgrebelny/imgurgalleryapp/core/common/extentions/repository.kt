package com.bezgrebelny.imgurgalleryapp.core.common.extentions

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

sealed class RepositoryError {
    object Error : RepositoryError()
}

suspend fun <T> getApiResult(body: suspend () -> T): ApiResult<T, RepositoryError> =
    try {
        withContext(Dispatchers.IO) {
            ApiResult.Success<T, RepositoryError>(
                body.invoke()
            )
        }
    } catch (e: Exception) {
        Log.e(TAG, "getApiResult: ", e)
        ApiResult.Error(
            RepositoryError.Error,
            e
        )
    }

private const val TAG = "getApiResult"