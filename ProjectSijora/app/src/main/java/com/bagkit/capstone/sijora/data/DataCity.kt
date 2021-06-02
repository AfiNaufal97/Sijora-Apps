package com.bagkit.capstone.sijora.data.model

import com.bagkit.capstone.sijora.R


object DataCity {
    val tagName = arrayOf(
        "Sampah",
        "Macet",
        "Krl",
        "TransJakarta",
        "CepatResponJKT",
        "ancol",
        "dufan",
        "jalan jakarta"
    )

    val imgCity = arrayOf(
        R.drawable.ic_hashtag,
        R.drawable.ic_hashtag,
        R.drawable.ic_hashtag,
        R.drawable.ic_hashtag,
        R.drawable.ic_hashtag,
        R.drawable.ic_hashtag,
        R.drawable.ic_hashtag,
        R.drawable.ic_hashtag
    )


    val listData: ArrayList<ModelCity>
        get() {
            val list = arrayListOf<ModelCity>()
            for (position in tagName.indices){
                val modelCity = ModelCity()
                modelCity.tagName = tagName[position]
                modelCity.imgCity = imgCity[position]
                list.add(modelCity)
            }
            return list
        }

}