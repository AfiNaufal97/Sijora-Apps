package com.bagkit.capstone.sijora.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bagkit.capstone.sijora.MainActivity
import com.bagkit.capstone.sijora.backend.api.Retrofits
import com.bagkit.capstone.sijora.backend.api.TwitterSearchApi

class ViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            val api = Retrofits.instanceRetrofit().create(TwitterSearchApi::class.java)
            return MainViewModel(api) as T
        }else{
            throw Throwable("Unknown view Model")
        }
    }

}