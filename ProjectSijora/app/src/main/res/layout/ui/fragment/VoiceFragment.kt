package com.wildan.sijoraapps.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.wildan.sijoraapps.R
import com.wildan.sijoraapps.data.data.DataTransportation
import com.wildan.sijoraapps.data.data.DataVoice
import com.wildan.sijoraapps.data.model.ModelTransportation
import com.wildan.sijoraapps.data.model.ModelVoice
import com.wildan.sijoraapps.databinding.FragmentTransportBinding
import com.wildan.sijoraapps.databinding.FragmentVoiceBinding
import com.wildan.sijoraapps.ui.adapter.AdapterTransportation
import com.wildan.sijoraapps.ui.adapter.AdapterVoice

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