package com.bagkit.capstone.sijora.backend.api.twitter

import com.bagkit.capstone.sijora.backend.modeltwitter.DataTwitter
import com.bagkit.capstone.sijora.backend.modeltwitter.ModelTwitter
import retrofit2.http.GET

import retrofit2.http.Headers
import retrofit2.http.Query

interface EndPointTwitter {

    @GET("recent?")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getFromClick(@Query("query")query:String):retrofit2.Call<ModelTwitter<DataTwitter>>

    @GET("recent?query=sekolah jakarta&max_results=100")
    @Headers("Authorization: Bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getFromJakarta():retrofit2.Call<ModelTwitter<DataTwitter>>
}