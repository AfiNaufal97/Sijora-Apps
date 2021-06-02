package com.bagkit.capstone.sijora.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bagkit.capstone.sijora.backend.api.TwitterSearchApi
import com.bagkit.capstone.sijora.backend.modelapi.BaseResponse
import com.bagkit.capstone.sijora.backend.modelapi.Data
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val api:TwitterSearchApi):ViewModel(){

    private val myData = MutableLiveData<MutableList<Data>>(mutableListOf())
    private val myDataMacet = MutableLiveData<MutableList<Data>>(mutableListOf())

    fun getMyData():LiveData<MutableList<Data>> = myData
    fun getMyDataMacet():LiveData<MutableList<Data>> = myDataMacet

    fun test(){
        viewModelScope.launch {
            api.getSampah1().enqueue(object: Callback<BaseResponse>{
                override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                    Log.d("xixixi", "getSampah done")
                    if(response.isSuccessful){
                        val current = myData.value
                        val body = response.body()
                        body?.let{
                            val temp = it.data.toMutableList()
                            current!!.addAll(temp)
                            myData.value = current
                        }
                    }else{
                        Log.e("Error get", response.code().toString())
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    Log.e("Exception", t.message.toString())
                }
            })

            api.getSampah2().enqueue(object: Callback<BaseResponse>{
                override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                    Log.d("xixixi", "getSampah done")
                    if(response.isSuccessful){
                        val current = myData.value
                        val body = response.body()
                        body?.let{
                            val temp = it.data.toMutableList()
                            current!!.addAll(temp)
                            myData.value = current
                        }
                    }else{
                        Log.e("Error get", response.code().toString())
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    Log.e("Exception", t.message.toString())
                }
            })

            api.getSampah3().enqueue(object: Callback<BaseResponse>{
                override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                    Log.d("xixixi", "getSampah done")
                    if(response.isSuccessful){
                        val current = myData.value
                        val body = response.body()
                        body?.let{
                            val temp = it.data.toMutableList()
                            current!!.addAll(temp)
                            myData.value = current
                        }
                    }else{
                        Log.e("Error get", response.code().toString())
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    Log.e("Exception", t.message.toString())
                }
            })

            api.getSampah4().enqueue(object: Callback<BaseResponse>{
                override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                    Log.d("xixixi", "getSampah done")
                    if(response.isSuccessful){
                        val current = myData.value
                        val body = response.body()
                        body?.let{
                            val temp = it.data.toMutableList()
                            current!!.addAll(temp)
                            myData.value = current
                        }
                    }else{
                        Log.e("Error get", response.code().toString())
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    Log.e("Exception", t.message.toString())
                }
            })

            api.getSampah5().enqueue(object: Callback<BaseResponse>{
                override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                    Log.d("xixixi", "getSampah done")
                    if(response.isSuccessful){
                        val current = myData.value
                        val body = response.body()
                        body?.let{
                            val temp = it.data.toMutableList()
                            current!!.addAll(temp)
                            myData.value = current
                        }
                    }else{
                        Log.e("Error get", response.code().toString())
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    Log.e("Exception", t.message.toString())
                }
            })
        }
    }

    fun testMacet(){
        viewModelScope.launch {
            api.getMacet1().enqueue(object: Callback<BaseResponse>{
                override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                    Log.d("xixixi", "getMacet done")
                    if(response.isSuccessful){
                        val current = myDataMacet.value
                        val body = response.body()
                        body?.let{
                            val temp = it.data.toMutableList()
                            current!!.addAll(temp)
                            myDataMacet.value = current
                        }
                    }else{
                        Log.e("Error get", response.code().toString())
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    Log.e("Exception", t.message.toString())
                }
            })

            api.getMacet2().enqueue(object: Callback<BaseResponse>{
                override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                    Log.d("xixixi", "getMacet done")
                    if(response.isSuccessful){
                        val current = myDataMacet.value
                        val body = response.body()
                        body?.let{
                            val temp = it.data.toMutableList()
                            current!!.addAll(temp)
                            myDataMacet.value = current
                        }
                    }else{
                        Log.e("Error get", response.code().toString())
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    Log.e("Exception", t.message.toString())
                }
            })

            api.getMacet3().enqueue(object: Callback<BaseResponse>{
                override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                    Log.d("xixixi", "getMacet done")
                    if(response.isSuccessful){
                        val current = myDataMacet.value
                        val body = response.body()
                        body?.let{
                            val temp = it.data.toMutableList()
                            current!!.addAll(temp)
                            myDataMacet.value = current
                        }
                    }else{
                        Log.e("Error get", response.code().toString())
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    Log.e("Exception", t.message.toString())
                }
            })

//            api.getMacet4().enqueue(object: Callback<BaseResponse>{
//                override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
//                    Log.d("xixixi", "getMacet done")
//                    if(response.isSuccessful){
//                        val current = myDataMacet.value
//                        val body = response.body()
//                        body?.let{
//                            val temp = it.data.toMutableList()
//                            current!!.addAll(temp)
//                            myDataMacet.value = current
//                        }
//                    }else{
//                        Log.e("Error get", response.code().toString())
//                    }
//                }

//                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
//                    Log.e("Exception", t.message.toString())
//                }
//            })

            api.getMacet5().enqueue(object: Callback<BaseResponse>{
                override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                    Log.d("xixixi", "getMacet done")
                    if(response.isSuccessful){
                        val current = myDataMacet.value
                        val body = response.body()
                        body?.let{
                            val temp = it.data.toMutableList()
                            current!!.addAll(temp)
                            myDataMacet.value = current
                        }
                    }else{
                        Log.e("Error get", response.code().toString())
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    Log.e("Exception", t.message.toString())
                }
            })
        }
    }

}