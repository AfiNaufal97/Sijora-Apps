package com.wildan.sijoraapps.data

import com.wildan.sijoraapps.R

object DataCity {

    val tagName = arrayOf(
        "#City1",
        "#City2",
        "#City3",
        "#City4",
        "#City5",
        "#City6"
    )

    val imgCity = arrayOf(
        R.drawable.ic_profile,
        R.drawable.ic_profile,
        R.drawable.ic_profile,
        R.drawable.ic_profile,
        R.drawable.ic_profile,
        R.drawable.ic_profile
    )

    val jumlah = arrayOf(
        100,
        200,
        300,
        400,
        500,
        600
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