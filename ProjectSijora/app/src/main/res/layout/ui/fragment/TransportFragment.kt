package com.wildan.sijoraapps.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.wildan.sijoraapps.R
import com.wildan.sijoraapps.data.data.DataMedical
import com.wildan.sijoraapps.data.data.DataTransportation
import com.wildan.sijoraapps.data.model.ModelMedical
import com.wildan.sijoraapps.data.model.ModelTransportation
import com.wildan.sijoraapps.databinding.FragmentMedicalBinding
import com.wildan.sijoraapps.databinding.FragmentTransportBinding
import com.wildan.sijoraapps.ui.adapter.AdapterMedical
import com.wildan.sijoraapps.ui.adapter.AdapterTransportation


class TransportFragment : Fragment() {

    private lateinit var binding : FragmentTransportBinding
    val list = ArrayList<ModelTransportation>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTransportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.setHasFixedSize(true)

        list.addAll(DataTransportation.listData)

        val adapter = AdapterTransportation(list)
        binding.recyclerView.adapter = adapter
    }

}