package com.wildan.sijoraapps.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.wildan.sijoraapps.R
import com.wildan.sijoraapps.data.data.DataCity
import com.wildan.sijoraapps.data.data.DataElectric
import com.wildan.sijoraapps.data.model.ModelCity
import com.wildan.sijoraapps.data.model.ModelElectric
import com.wildan.sijoraapps.databinding.FragmentCityBinding
import com.wildan.sijoraapps.databinding.FragmentElectricBinding
import com.wildan.sijoraapps.ui.adapter.AdapterCity
import com.wildan.sijoraapps.ui.adapter.AdapterElectric


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