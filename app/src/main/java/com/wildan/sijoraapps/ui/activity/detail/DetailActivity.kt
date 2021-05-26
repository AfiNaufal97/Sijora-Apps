package com.wildan.sijoraapps.ui.activity.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wildan.sijoraapps.R
import com.wildan.sijoraapps.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    companion object{
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_COUNT = "extra_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tagname = intent.getStringExtra(EXTRA_TITLE)
        val count = intent.getStringExtra(EXTRA_COUNT)

        binding.tvDetailTitle.text = tagname
        binding.tvDetailCount.text = getString(R.string.count, count)
    }
}