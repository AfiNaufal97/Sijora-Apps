package com.bagkit.capstone.sijora.backend.api

import com.bagkit.capstone.sijora.backend.modelapi.BaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface TwitterSearchApi {
    // All
    @GET("recent?")
    // header
    fun getFromClick(@Query("query")query:String):Call<BaseResponse>
}