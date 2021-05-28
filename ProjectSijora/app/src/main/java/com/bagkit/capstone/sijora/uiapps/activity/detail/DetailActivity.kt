package com.bagkit.capstone.sijora.uiapps.activity.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bagkit.capstone.sijora.R
import com.bagkit.capstone.sijora.databinding.ActivityDetailBinding
import com.bagkit.capstone.sijora.uiapps.activity.analysis.AnalysisActivity


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
        binding.btnAnalysis.setOnClickListener {
            val intent = Intent(this, AnalysisActivity::class.java)
            intent.putExtra(AnalysisActivity.EXTRA_TITLE, tagname)
            intent.putExtra(AnalysisActivity.EXTRA_COUNT, count)
            startActivity(intent)
        }
    }
}