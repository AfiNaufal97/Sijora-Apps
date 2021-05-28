package com.bagkit.capstone.sijora.uiapps.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagkit.capstone.sijora.data.model.DataElectric
import com.bagkit.capstone.sijora.data.model.ModelElectric
import com.bagkit.capstone.sijora.databinding.FragmentElectricBinding
import com.bagkit.capstone.sijora.uiapps.adapter.AdapterElectric


class ElectricFragment : Fragment() {

    private lateinit var binding : FragmentElectricBinding
    val list = ArrayList<ModelElectric>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentElectricBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.setHasFixedSize(true)

        list.addAll(DataElectric.listData)

        val adapter = AdapterElectric(list)
        binding.recyclerView.adapter = adapter
    }

}