package com.bagkit.capstone.sijora.backend.api.twitter

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitTwitter {
    companion object{
        val retrofitRorTwiter = Retrofit.Builder()
            .baseUrl("https://api.twitter.com/2/tweets/search/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofitRorTwiter.create(EndPointTwitter::class.java)
    }
}