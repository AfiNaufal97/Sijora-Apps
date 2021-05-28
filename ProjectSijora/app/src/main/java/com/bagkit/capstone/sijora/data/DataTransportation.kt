package com.bagkit.capstone.sijora.data.model

import com.bagkit.capstone.sijora.R

object DataTransportation {

    val tagName = arrayOf(
        "#Transportation1",
        "#Transportation2",
        "#Transportation3",
        "#Transportation4",
        "#Transportation5",
        "#Transportation6",
        "#Transportation7",
        "#Transportation8"
    )

    val imgTransportation = arrayOf(
        R.drawable.ic_hashtag,
        R.drawable.ic_hashtag,
        R.drawable.ic_hashtag,
        R.drawable.ic_hashtag,
        R.drawable.ic_hashtag,
        R.drawable.ic_hashtag,
        R.drawable.ic_hashtag,
        R.drawable.ic_hashtag
    )

    val jumlah = arrayOf(
        100,
        200,
        300,
        400,
        500,
        600,
        700,
        800
    )


    val listData: ArrayList<ModelTransportation>
        get() {
            val list = arrayListOf<ModelTransportation>()
            for (position in tagName.indices){
                val modelTransportation = ModelTransportation()
                modelTransportation.tagName = tagName[position]
                modelTransportation.imgTransportation = imgTransportation[position]
                modelTransportation.jumlah = jumlah[position]
                list.add(modelTransportation)
            }
            return list
        }

}