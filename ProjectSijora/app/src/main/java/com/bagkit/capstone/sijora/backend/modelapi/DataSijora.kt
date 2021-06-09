package com.bagkit.capstone.sijora.backend.modelapi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataSijora(
    val id:Int,
    val input_mobile:String,
    val output_negative:String,
    val output_positive:String
):Parcelable
