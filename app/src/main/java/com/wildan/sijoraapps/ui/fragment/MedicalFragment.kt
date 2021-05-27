package com.wildan.sijoraapps.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.wildan.sijoraapps.R
import com.wildan.sijoraapps.data.data.DataElectric
import com.wildan.sijoraapps.data.data.DataMedical
import com.wildan.sijoraapps.data.model.ModelMedical
import com.wildan.sijoraapps.databinding.FragmentElectricBinding
import com.wildan.sijoraapps.databinding.FragmentMedicalBinding
import com.wildan.sijoraapps.ui.adapter.AdapterElectric
import com.wildan.sijoraapps.ui.adapter.AdapterMedical


class MedicalFragment : Fragment() {

    private lateinit var binding : FragmentMedicalBinding
    val list = ArrayList<ModelMedical>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMedicalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.setHasFixedSize(true)

        list.addAll(DataMedical.listData)

        val adapter = AdapterMedical(list)
        binding.recyclerView.adapter = adapter
    }

}