package com.bagkit.capstone.sijora.uiapps.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagkit.capstone.sijora.data.model.DataMedical
import com.bagkit.capstone.sijora.data.model.ModelMedical
import com.bagkit.capstone.sijora.databinding.FragmentMedicalBinding
import com.bagkit.capstone.sijora.uiapps.adapter.AdapterMedical


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