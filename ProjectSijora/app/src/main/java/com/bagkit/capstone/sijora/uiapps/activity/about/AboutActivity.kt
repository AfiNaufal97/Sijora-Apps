package com.bagkit.capstone.sijora.uiapps.activity.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bagkit.capstone.sijora.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding:ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackAbout.setOnClickListener {
            onBackPressed().also {
                finish()
            }
        }
    }
}