package com.bagkit.capstone.sijora.backend.api

import com.bagkit.capstone.sijora.backend.modelapi.Data
import com.bagkit.capstone.sijora.backend.modelapi.BaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface TwitterSearchApi {

    // sampah
    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-27T07:20:50.52Z&end_time=2021-05-28T07:20:50.52Z&tweet.fields=text&query=sampah dki&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getSampah1():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-28T07:20:50.52Z&end_time=2021-05-29T07:20:50.52Z&tweet.fields=text&query=sampah dki&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getSampah2():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-29T07:20:50.52Z&end_time=2021-05-30T07:20:50.52Z&tweet.fields=text&query=sampah dki&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getSampah3():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-30T07:20:50.52Z&end_time=2021-05-31T07:20:50.52Z&tweet.fields=text&query=sampah dki&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getSampah4():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-31T07:20:50.52Z&end_time=2021-06-01T07:20:50.52Z&tweet.fields=text&query=sampah dki&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getSampah5():Call<BaseResponse>



    // macet
    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-27T07:20:50.52Z&end_time=2021-05-28T07:20:50.52Z&tweet.fields=text&query=macet jakarta&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getMacet1():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-28T07:20:50.52Z&end_time=2021-05-29T07:20:50.52Z&tweet.fields=text&query=macet jakarta&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getMacet2():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-29T07:20:50.52Z&end_time=2021-05-30T07:20:50.52Z&tweet.fields=text&query=macet jakarta&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getMacet3():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-30T07:20:50.52Z&end_time=2021-05-31T07:20:50.52Z&tweet.fields=text&query=macet jakarta&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getMacet4():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-31T07:20:50.52Z&end_time=2021-06-01T07:20:50.52Z&tweet.fields=text&query=macet jakarta&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getMacet5():Call<BaseResponse>


    // covid
    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-27T07:20:50.52Z&end_time=2021-05-28T07:20:50.52Z&tweet.fields=text&query=covid19 dki&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getCovid1():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-28T07:20:50.52Z&end_time=2021-05-29T07:20:50.52Z&tweet.fields=text&query=covid19 dki&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getCovid2():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-29T07:20:50.52Z&end_time=2021-05-30T07:20:50.52Z&tweet.fields=text&query=covid19 dki&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getCovid3():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-30T07:20:50.52Z&end_time=2021-05-31T07:20:50.52Z&tweet.fields=text&query=covid19 dki&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getCovid4():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-31T07:20:50.52Z&end_time=2021-06-01T07:20:50.52Z&tweet.fields=text&query=covid19 dki&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getCovid5():Call<BaseResponse>


    // krl
    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-27T07:20:50.52Z&end_time=2021-05-28T07:20:50.52Z&tweet.fields=text&query=krl&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getKrl1():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-28T07:20:50.52Z&end_time=2021-05-29T07:20:50.52Z&tweet.fields=text&query=krl&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getKrl2():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-29T07:20:50.52Z&end_time=2021-05-30T07:20:50.52Z&tweet.fields=text&query=krl&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getKrl3():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-30T07:20:50.52Z&end_time=2021-05-31T07:20:50.52Z&tweet.fields=text&query=krl&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getKrl4():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-31T07:20:50.52Z&end_time=2021-06-01T07:20:50.52Z&tweet.fields=text&query=krl&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getKrl5():Call<BaseResponse>


    // transjakarta
    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-27T07:20:50.52Z&end_time=2021-05-28T07:20:50.52Z&tweet.fields=text&query=krl&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getTransJakarta1():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-28T07:20:50.52Z&end_time=2021-05-29T07:20:50.52Z&tweet.fields=text&query=krl&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getTransJakarta2():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-29T07:20:50.52Z&end_time=2021-05-30T07:20:50.52Z&tweet.fields=text&query=krl&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getTransJakarta3():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-30T07:20:50.52Z&end_time=2021-05-31T07:20:50.52Z&tweet.fields=text&query=krl&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getTransJakarta():Call<BaseResponse>

    @GET("https://api.twitter.com/2/tweets/search/recent?start_time=2021-05-31T07:20:50.52Z&end_time=2021-06-01T07:20:50.52Z&tweet.fields=text&query=krl&max_results=10")
    @Headers("Authorization: bearer AAAAAAAAAAAAAAAAAAAAAL7FPwEAAAAADsN8xfx4GV4qNa9auwJFwPuFMaQ%3Dm4FPJLHCpfzeyUbxOagYQC4JNSkTafirl10WFIwKVUmDPtGMoE")
    fun getTransJakarta5():Call<BaseResponse>

}