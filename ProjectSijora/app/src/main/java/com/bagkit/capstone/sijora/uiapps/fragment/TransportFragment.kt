package com.bagkit.capstone.sijora.uiapps.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagkit.capstone.sijora.data.model.DataTransportation
import com.bagkit.capstone.sijora.data.model.ModelTransportation
import com.bagkit.capstone.sijora.databinding.FragmentTransportBinding
import com.bagkit.capstone.sijora.uiapps.adapter.AdapterTransportation


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