package com.wildan.sijoraapps.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.wildan.sijoraapps.data.data.DataEducation
import com.wildan.sijoraapps.data.model.ModelEducation
import com.wildan.sijoraapps.databinding.FragmentEducationBinding
import com.wildan.sijoraapps.ui.adapter.AdapterEducation

class EducationFragment : Fragment() {

    private lateinit var binding: FragmentEducationBinding
    val list = ArrayList<ModelEducation>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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