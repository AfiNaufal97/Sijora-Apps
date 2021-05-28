package com.bagkit.capstone.sijora.uiapps.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagkit.capstone.sijora.backend.api.Retrofits
import com.bagkit.capstone.sijora.backend.modelapi.Data
import com.bagkit.capstone.sijora.backend.modelapi.MultipleData
import com.bagkit.capstone.sijora.data.model.DataCity
import com.bagkit.capstone.sijora.data.model.ModelCity
import com.bagkit.capstone.sijora.databinding.FragmentCityBinding
import com.bagkit.capstone.sijora.uiapps.adapter.AdapterCity
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CityFragment : Fragment() {

    private lateinit var binding : FragmentCityBinding
    val list = ArrayList<ModelCity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setApi()
    }


    private fun setApi() {
        Retrofits.api.getMasalahMacet().enqueue(object: Callback<MultipleData<Data>>{
            override fun onResponse(call: Call<MultipleData<Data>>, response: Response<MultipleData<Data>>) {
                if(response.isSuccessful){
                    val data = response.body()!!.data
                    setRecylerview(data)
                }
            }

            override fun onFailure(call: Call<MultipleData<Data>>, t: Throwable) {
                Toast.makeText(context!!.applicationContext, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun setRecylerview(data:List<Data>){
        binding.recyclerView.apply {
            val adapterData = AdapterCity(data)
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = adapterData
        }
    }

}