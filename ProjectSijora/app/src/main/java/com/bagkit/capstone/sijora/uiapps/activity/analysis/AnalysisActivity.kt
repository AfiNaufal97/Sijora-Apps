package com.bagkit.capstone.sijora.uiapps.activity.analysis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bagkit.capstone.sijora.R
import com.bagkit.capstone.sijora.databinding.ActivityAnalysisBinding


class AnalysisActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnalysisBinding
    companion object{
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_COUNT = "extra_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnalysisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tagname = intent.getStringExtra(EXTRA_TITLE)
        val count = intent.getStringExtra(EXTRA_COUNT)

        binding.tvAnalysisTitle.text = tagname
        binding.tvAnalysisCount.text = getString(R.string.count, count)
    }
}