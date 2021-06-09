package com.bagkit.capstone.sijora.backend.api.new

import com.bagkit.capstone.sijora.backend.modelapi.DataSijora
import com.bagkit.capstone.sijora.backend.modelapi.ModelApiMultiple
import com.bagkit.capstone.sijora.backend.modelapi.ModelApiSingle
import retrofit2.Call
import retrofit2.http.*

interface Endpoint {

    @GET("sentiment")
    fun getData(): Call<ModelApiMultiple<DataSijora>>

    @GET("sentiment/{id}")
    fun getDataById(@Path("id")id:Int): Call<ModelApiSingle<DataSijora>>

    @POST("sentiment")
    fun postDataById(@Body dataSijora: DataSijora): Call<ModelApiSingle<DataSijora>>

    @PUT("sentiment/{id}")
    fun editDataById(
        @Path("id")id:Int,
        @Body dataSijora: DataSijora
    ): Call<ModelApiSingle<DataSijora>>

    @DELETE("sentiment/{id}")
    fun deleteDataById(
        @Path("id")id:Int
    ): Call<Void>

}