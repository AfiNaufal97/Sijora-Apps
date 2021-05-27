package com.wildan.sijoraapps.data.data

import com.wildan.sijoraapps.R
import com.wildan.sijoraapps.data.model.ModelCity

object DataCity {

    val tagName = arrayOf(
        "#City1",
        "#City2",
        "#City3",
        "#City4",
        "#City5",
        "#City6",
        "#City7",
        "#City8"
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


    val listData: ArrayList<ModelCity>
        get() {
            val list = arrayListOf<ModelCity>()
            for (position in tagName.indices){
                val modelCity = ModelCity()
                modelCity.tagName = tagName[position]
                modelCity.imgCity = imgCity[position]
                modelCity.jumlah = jumlah[position]
                list.add(modelCity)
            }
            return list
        }

}