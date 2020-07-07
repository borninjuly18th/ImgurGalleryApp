package com.bezgrebelny.imgurgalleryapp.core.api

import android.util.Log
import com.bezgrebelny.imgurgalleryapp.core.common.extentions.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class ApiHelper {

    protected suspend inline fun <T> getApiResult(noinline body: suspend () -> T): ApiResult<T, ApiError> =
        try {
            withContext(Dispatchers.IO) {
                ApiResult.Success<T, ApiError>(body.invoke())
            }
        } catch (e: Exception) {
            Log.e(TAG, "getApiResult: ", e)
            ApiResult.Error(
                ApiError.Error,
                e
            )
        }

    sealed class ApiError {
        object Error : ApiError()
    }

    companion object {
        const val TAG = "getApiResult"
    }
}