package com.wildan.sijoraapps.data.data

import com.wildan.sijoraapps.R
import com.wildan.sijoraapps.data.model.ModelVoice

object DataVoice {

    val tagName = arrayOf(
        "#Voice1",
        "#Voice2",
        "#Voice3",
        "#Voice4",
        "#Voice5",
        "#Voice6",
        "#Voice7",
        "#Voice8"
    )

    val imgVoice = arrayOf(
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


    val listData: ArrayList<ModelVoice>
        get() {
            val list = arrayListOf<ModelVoice>()
            for (position in tagName.indices){
                val modelVoice = ModelVoice()
                modelVoice.tagName = tagName[position]
                modelVoice.imgVoice = imgVoice[position]
                modelVoice.jumlah = jumlah[position]
                list.add(modelVoice)
            }
            return list
        }

}