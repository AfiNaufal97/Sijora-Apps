package com.bagkit.capstone.sijora.uiapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bagkit.capstone.sijora.data.model.ModelCity
import com.bagkit.capstone.sijora.databinding.ItemList2Binding
import com.bumptech.glide.Glide


class AdapterCity(val listCity: ArrayList<ModelCity>): RecyclerView.Adapter<AdapterCity.CityViewHolder>() {

    lateinit var setClickCity:SetOnClickCityList

    interface SetOnClickCityList {
        fun clickListCity(data:ModelCity)
    }

    fun clickCity(setClickCity: SetOnClickCityList){
        this.setClickCity = setClickCity
    }

    inner class CityViewHolder(val binding: ItemList2Binding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ModelCity) {
            binding.textViewTitle.text = data.tagName
            Glide.with(itemView.context)
                .load(data.imgCity)
                .into(binding.circleImageView2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val binding = ItemList2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val data = listCity[position]
        holder.bind(data)
        holder.itemView.setOnClickListener {
            setClickCity.clickListCity(data)
        }
    }

    override fun getItemCount(): Int {
        return listCity.size
    }
}