package com.bagkit.capstone.sijora.uiapps.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagkit.capstone.sijora.data.model.DataEducation
import com.bagkit.capstone.sijora.data.model.ModelEducation
import com.bagkit.capstone.sijora.databinding.FragmentEducationBinding
import com.bagkit.capstone.sijora.uiapps.adapter.AdapterEducation


class EducationFragment : Fragment() {

    private lateinit var binding: FragmentEducationBinding
    val list = ArrayList<ModelEducation>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEducationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.setHasFixedSize(true)

        list.addAll(DataEducation.listData)

        val adapter = AdapterEducation(list)
        binding.recyclerView.adapter = adapter
    }

}