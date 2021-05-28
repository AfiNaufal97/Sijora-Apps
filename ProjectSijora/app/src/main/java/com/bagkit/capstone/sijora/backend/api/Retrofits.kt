package com.bagkit.capstone.sijora.backend.api

import com.bagkit.capstone.sijora.backend.constanta.Constanta.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofits {
    companion object{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(APIEndpoint::class.java)
    }
}