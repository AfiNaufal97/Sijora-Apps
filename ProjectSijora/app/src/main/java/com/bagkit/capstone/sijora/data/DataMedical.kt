package com.bagkit.capstone.sijora.data.model

import com.bagkit.capstone.sijora.R


object DataMedical {

    val tagName = arrayOf(
        "#Medical1",
        "#Medical2",
        "#Medical3",
        "#Medical4",
        "#Medical5",
        "#Medical6",
        "#Medical7",
        "#Medical8"
    )

    val imgMedical = arrayOf(
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


    val listData: ArrayList<ModelMedical>
        get() {
            val list = arrayListOf<ModelMedical>()
            for (position in tagName.indices){
                val modelMedical = ModelMedical()
                modelMedical.tagName = tagName[position]
                modelMedical.imgMedical = imgMedical[position]
                modelMedical.jumlah = jumlah[position]
                list.add(modelMedical)
            }
            return list
        }

}