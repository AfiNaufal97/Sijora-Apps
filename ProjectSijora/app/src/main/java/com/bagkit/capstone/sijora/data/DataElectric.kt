package com.bagkit.capstone.sijora.data.model

import com.bagkit.capstone.sijora.R


object DataElectric {
    val tagName = arrayOf(
        "#Electric1",
        "#Electric2",
        "#Electric3",
        "#Electric4",
        "#Electric5",
        "#Electric6",
        "#Electric7",
        "#Electric8"
    )

    val imgElectric = arrayOf(
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


    val listData: ArrayList<ModelElectric>
        get() {
            val list = arrayListOf<ModelElectric>()
            for (position in tagName.indices){
                val modelElectric = ModelElectric()
                modelElectric.tagName = tagName[position]
                modelElectric.imgElectric = imgElectric[position]
                modelElectric.jumlah = jumlah[position]
                list.add(modelElectric)
            }
            return list
        }
}