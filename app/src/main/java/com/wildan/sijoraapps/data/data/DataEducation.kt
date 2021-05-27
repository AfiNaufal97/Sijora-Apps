package com.wildan.sijoraapps.data.data

import com.wildan.sijoraapps.R
import com.wildan.sijoraapps.data.model.ModelCity
import com.wildan.sijoraapps.data.model.ModelEducation

object DataEducation {

    val tagName = arrayOf(
        "#Education1",
        "#Education2",
        "#Education3",
        "#Education4",
        "#Education5",
        "#Education6",
        "#Education7",
        "#Education8"
    )

    val imgEducation = arrayOf(
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


    val listData: ArrayList<ModelEducation>
        get() {
            val list = arrayListOf<ModelEducation>()
            for (position in tagName.indices){
                val modelEducation = ModelEducation()
                modelEducation.tagName = tagName[position]
                modelEducation.imgEducation = imgEducation[position]
                modelEducation.jumlah = jumlah[position]
                list.add(modelEducation)
            }
            return list
        }

}