package com.bagkit.capstone.sijora.backend.modelapi

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("data")
    var data :List<Data>
)