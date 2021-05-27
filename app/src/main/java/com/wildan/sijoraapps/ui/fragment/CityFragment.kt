package com.wildan.sijoraapps.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.wildan.sijoraapps.data.data.DataCity
import com.wildan.sijoraapps.data.model.ModelCity
import com.wildan.sijoraapps.databinding.FragmentCityBinding
import com.wildan.sijoraapps.ui.adapter.AdapterCity


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