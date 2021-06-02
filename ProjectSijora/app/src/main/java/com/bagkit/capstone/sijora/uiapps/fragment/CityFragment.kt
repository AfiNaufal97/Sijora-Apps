package com.bagkit.capstone.sijora.uiapps.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagkit.capstone.sijora.backend.api.Retrofits
import com.bagkit.capstone.sijora.backend.modelapi.Data
import com.bagkit.capstone.sijora.backend.modelapi.BaseResponse
import com.bagkit.capstone.sijora.data.model.DataCity
import com.bagkit.capstone.sijora.data.model.DataEducation
import com.bagkit.capstone.sijora.data.model.ModelCity
import com.bagkit.capstone.sijora.databinding.FragmentCityBinding
import com.bagkit.capstone.sijora.uiapps.activity.detail.DetailActivity
import com.bagkit.capstone.sijora.uiapps.adapter.AdapterCity
import com.bagkit.capstone.sijora.uiapps.adapter.AdapterEducation
import com.bagkit.capstone.sijora.viewmodel.MainViewModel
import com.bagkit.capstone.sijora.viewmodel.ViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CityFragment : Fragment() {


    private lateinit var binding : FragmentCityBinding
    val list = ArrayList<ModelCity>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.setHasFixedSize(true)

        list.addAll(DataCity.listData)

        val adapter = AdapterCity(list)
        binding.recyclerView.adapter = adapter
        adapter.clickCity(object:AdapterCity.SetOnClickCityList{
            override fun clickListCity(data: ModelCity) {
               startActivity(Intent(activity, DetailActivity::class.java)
                   .putExtra("id", 1)
                   .putExtra("name", data.tagName))
            }

        })
    }


}