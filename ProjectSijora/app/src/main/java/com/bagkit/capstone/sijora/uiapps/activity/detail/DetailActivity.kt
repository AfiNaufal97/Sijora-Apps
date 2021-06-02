package com.bagkit.capstone.sijora.uiapps.activity.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bagkit.capstone.sijora.R
import com.bagkit.capstone.sijora.backend.modelapi.Data
import com.bagkit.capstone.sijora.databinding.ActivityDetailBinding
import com.bagkit.capstone.sijora.uiapps.activity.analysis.AnalysisActivity
import com.bagkit.capstone.sijora.viewmodel.MainViewModel
import com.bagkit.capstone.sijora.viewmodel.ViewModelFactory


class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    private lateinit var binding: ActivityDetailBinding
    companion object{
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_COUNT = "extra_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra("id", 0)
        val nama = intent.getStringExtra("name")

        setView(nama!!)
        binding.tvDetailTitle.text = nama

    }

    private fun fetchData() {
        viewModel.test()
    }

    private fun fetchDataMacet() {
        viewModel.testMacet()
    }

    private fun observe() {
        viewModel.getMyData().observe(this, {handleData(it)})
    }

    private fun observeMacet() {
        viewModel.getMyDataMacet().observe(this, {handleDataMacet(it)})
    }

    private fun handleData(it: MutableList<Data>?) {
        if(it != null ){
            binding.tvDetailCount.text = it.size.toString()
        }
    }

    private fun handleDataMacet(it: MutableList<Data>?) {
        if(it != null ){
            binding.tvDetailCount.text = it.size.toString()
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory()).get(MainViewModel::class.java)
    }

    private fun setView(id: String) {
        when(id){
            "Sampah" ->{
                setValueSampah()
            }
            "Macet" -> {
                setValueMacet()
            }
        }
    }

    private fun setValueMacet() {
        setupViewModel()
        observeMacet()
        fetchDataMacet()
    }

    private fun setValueSampah() {
        setupViewModel()
        observe()
        fetchData()
    }
}