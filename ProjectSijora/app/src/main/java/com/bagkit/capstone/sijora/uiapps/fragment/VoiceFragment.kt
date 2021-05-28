package com.bagkit.capstone.sijora.uiapps.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagkit.capstone.sijora.data.model.DataVoice
import com.bagkit.capstone.sijora.data.model.ModelVoice
import com.bagkit.capstone.sijora.databinding.FragmentVoiceBinding
import com.bagkit.capstone.sijora.uiapps.adapter.AdapterVoice


class VoiceFragment : Fragment() {

    private lateinit var binding : FragmentVoiceBinding
    val list = ArrayList<ModelVoice>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVoiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.setHasFixedSize(true)

        list.addAll(DataVoice.listData)

        val adapter = AdapterVoice(list)
        binding.recyclerView.adapter = adapter
    }

}