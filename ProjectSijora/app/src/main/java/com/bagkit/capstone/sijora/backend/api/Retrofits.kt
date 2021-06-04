package com.bagkit.capstone.sijora.backend.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Retrofits {
    private var retrofit: Retrofit? = null
    private val okHttpClient = OkHttpClient.Builder().apply {
        writeTimeout(60, TimeUnit.SECONDS)
        connectTimeout(60, TimeUnit.SECONDS)
        readTimeout(60, TimeUnit.SECONDS)
    }.build()

    fun instanceRetrofit() : Retrofit  {
        if(retrofit == null){
            retrofit = Retrofit.Builder().apply {
                addConverterFactory(GsonConverterFactory.create())
                baseUrl("https://api.twitter.com/2/tweets/search/")
                client(okHttpClient)
            }.build()
            return retrofit!!
        }
        return retrofit!!
    }
}