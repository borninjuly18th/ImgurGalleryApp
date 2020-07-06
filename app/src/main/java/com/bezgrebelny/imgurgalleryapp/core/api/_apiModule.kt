package com.bezgrebelny.imgurgalleryapp.core.api

import com.bezgrebelny.imgurgalleryapp.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun Module.apiModule() {
    single { getJsonConverter() }
    single { getClient() }
    single { getAppService(client = get(), jsonConverter = get()) }
}

private fun getAppService(
    jsonConverter: GsonConverterFactory,
    client: OkHttpClient
): ApiGalleryService =
    Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(jsonConverter)
        .client(client)
        .build()
        .create(ApiGalleryService::class.java)

private fun getJsonConverter(): GsonConverterFactory =
    GsonConverterFactory.create(GsonBuilder().create())

private fun getClient(): OkHttpClient =
    OkHttpClient.Builder().addInterceptor { chain ->
        val original = chain.request()
        val request = original.newBuilder().run {
            header(AUTHORIZATION_HEADER_NAME, "$CLIENT_ID ${BuildConfig.CLIEND_ID}")
            method(original.method(), original.body())
            build()
        }
        chain.proceed(request)
    }.build()

private const val AUTHORIZATION_HEADER_NAME = "Authorization"
private const val CLIENT_ID = "Client-ID"