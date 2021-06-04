package com.bagkit.capstone.sijora.uiapps.activity.detail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bagkit.capstone.sijora.backend.modelapi.Data
import com.bagkit.capstone.sijora.databinding.ActivityDetailBinding
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

        val query = intent.getStringExtra("query")
        val nama = intent.getStringExtra("name")

        binding.tvDetailTitle.text = nama
        setupViewModel(query.toString())
        Toast.makeText(this, nama, Toast.LENGTH_SHORT).show()
        setupViewModel(nama.toString())
    }

    private fun setupViewModel(nama:String) {
        viewModel = ViewModelProvider(this, ViewModelFactory()).get(MainViewModel::class.java)
        viewModel.test(nama)
        viewModel.getMyData().observe(this, {
            handle(it)
        })
    }

    private fun handle(it: MutableList<Data>?) {
        if(it != null){
            binding.tvDetailCount.text = it.size.toString()
        }
    }

//    private fun setView(id: String) {
//        when(id){
//            "Sampah" ->{
//                setValueSampah()
//            }
//            "Macet" -> {
//                setValueMacet()
//            }
//            "Krl" -> {
//                setValueKrl()
//            }
//            "TransJakarta" -> {
//                setValueTransJakarta()
//            }
//            "JpoJKT" -> {
//                setValueJpoJakarta()
//            }
//            "Jalur Sepeda" -> {
//                setValueJalurSepedaJakarta()
//            }
//
//            "Jalur Pedestrian" -> {
//                setValueJalurPedestrianJakarta()
//            }
//
//            "Sekolah Offline" -> {
////                setValueSekolahOnlineJakarta()
//            }
//        }
//    }
//
//    private fun fetchData(id:Int) {
//        when(id){
//            1 -> viewModel.test()
//            2 -> viewModel.testMacet()
//            3 -> viewModel.testMyDataKrl()
//            4 -> viewModel.testMyDataTransJakarta()
//            5 -> viewModel.testMyDataJpoJakarta()
//            6 -> viewModel.testMyJalurSepeda()
//            7 -> viewModel.testMyJalurPedetrian()
////            8 -> viewModel.testMyDataSekolahOffline()
//        }
//    }
//
//    private fun observe(id :Int) {
//        when(id){
//            1 ->  viewModel.getMyData().observe(this, {
//                handleData(it)
//            })
//            2 ->  viewModel.getMyDataMacet().observe(this, {handleData(it)})
//            3 ->  viewModel.getMyDataKrl().observe(this, {handleData(it)})
//            4 ->  viewModel.getMyDataTransJakarta().observe(this, {handleData(it)})
//            5 ->  viewModel.getMyDataJpoJakarta().observe(this, {handleData(it)})
//            6 ->  viewModel.getMyDataJalurSepedaJakarta().observe(this, {handleData(it)})
//            7 ->  viewModel.getMyDataJalurPedestrianJakarta().observe(this, {handleData(it)})
////            8 ->  viewModel.getMyDataSekolahOfflineJakarta().observe(this, {handleData(it)})
//        }
//    }
//
//
//    private fun handleData(it: MutableList<Data>?) {
//            if (it != null) {
//                binding.tvDetailCount.text = it.size.toString()
//                val data = it
//                binding.btnAnalysis.setOnClickListener {
//                    for (i in data.indices) {
//                        Log.d("tampil", data[i].text)
//                    }
//            }
//        }
//    }
//
//
//    private fun setValueSampah() {
//        setupViewModel()
//        observe(1)
//        fetchData(1)
//    }
//
//    private fun setValueMacet() {
//        setupViewModel()
//        observe(2)
//        fetchData(2)
//    }
//
//    private fun setValueKrl() {
//        setupViewModel()
//        observe(3)
//        fetchData(3)
//    }
//
//    private fun setValueTransJakarta(){
//        setupViewModel()
//        observe(4)
//        fetchData(4)
//    }
//
//    private fun setValueJpoJakarta() {
//       setupViewModel()
//        observe(5)
//        fetchData(5)
//    }
//
//    private fun setValueJalurSepedaJakarta() {
//       setupViewModel()
//        observe(6)
//        fetchData(6)
//    }
//
//    private fun setValueJalurPedestrianJakarta() {
//        setupViewModel()
//        observe(7)
//        fetchData(7)
//    }

//    private fun setValueSekolahOnlineJakarta() {
//        setupViewModel()
//        observe(8)
//        fetchData(8)
//    }



}