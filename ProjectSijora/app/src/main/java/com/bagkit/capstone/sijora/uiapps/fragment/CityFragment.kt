package com.bagkit.capstone.sijora.uiapps.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagkit.capstone.sijora.data.model.DataCity
import com.bagkit.capstone.sijora.data.model.ModelCity
import com.bagkit.capstone.sijora.databinding.FragmentCityBinding
import com.bagkit.capstone.sijora.uiapps.adapter.AdapterCity


class CityFragment : Fragment() {

    private lateinit var binding : FragmentCityBinding
    val list = ArrayList<ModelCity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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

    }

}