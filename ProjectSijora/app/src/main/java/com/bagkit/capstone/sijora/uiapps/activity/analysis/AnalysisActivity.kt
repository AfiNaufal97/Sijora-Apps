package com.bagkit.capstone.sijora.uiapps.activity.analysis

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bagkit.capstone.sijora.R
import com.bagkit.capstone.sijora.backend.modelapi.DataSijora
import com.bagkit.capstone.sijora.databinding.ActivityAnalysisBinding
import com.bagkit.capstone.sijora.uiapps.activity.detail.DetailActivity
import com.bagkit.capstone.sijora.uiapps.activity.home.HomeActivity


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

        binding.toolbarAnalisis.setNavigationOnClickListener {
            onBackPressed().also {
                finish()
            }
        }

//        binding.tvTitleAnalisis.text = tagname
//        binding.tvAnalysisCount.text = getString(R.string.count, count)

        val intent = intent.getParcelableExtra<DataSijora>("data")
        for(i in 1..3){
            if(i == 3) {
                if (intent!!.output_negative == "" && intent!!.output_positive == "") {
                    binding.progresBarAnalisis.visibility = View.VISIBLE
                    startActivity(Intent(this, HomeActivity::class.java))
                    Toast.makeText(this, "Gagal Meneukan Hasil", Toast.LENGTH_SHORT).show()
                }
            }

            if (intent!!.output_negative == "" && intent!!.output_positive == "") {
                binding.progresBarAnalisis.visibility = View.VISIBLE
            }else{
                binding.textView2.text = intent.output_positive
                binding.textView9.text = intent.output_negative
                break
            }

        }
    }
}