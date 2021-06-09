package com.bagkit.capstone.sijora.backend.api.new

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ObjectRetrofit {
    companion object{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://sijoraapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Endpoint::class.java)
    }
}