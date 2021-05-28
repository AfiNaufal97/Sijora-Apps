package com.bagkit.capstone.sijora.backend.api

import com.bagkit.capstone.sijora.backend.modelapi.Data
import com.bagkit.capstone.sijora.backend.modelapi.MultipleData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIEndpoint {

    @GET("recent?max_results=10&query=macet jakarta")
    @Headers("Authorization: Bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%")
    fun getMasalahMacet():Call<MultipleData<Data>>

}