package com.bagkit.capstone.sijora.uiapps.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bagkit.capstone.sijora.backend.modelapi.Data
import com.bagkit.capstone.sijora.data.model.DataEducation.imgEducation
import com.bagkit.capstone.sijora.databinding.ItemList2Binding
import com.bumptech.glide.Glide


class AdapterCity(val listCity: List<Data> ): RecyclerView.Adapter<AdapterCity.CityViewHolder>() {
    inner class CityViewHolder(val binding: ItemList2Binding): RecyclerView.ViewHolder(binding.root) {
        fun bind(listData: Data) {
            Glide.with(itemView.context)
                .load(imgEducation)
                .into(binding.circleImageView2)
            binding.textView3.text = listData.text
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val binding = ItemList2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val listData = listCity[position]
        holder.bind(listData)
    }

    override fun getItemCount(): Int {
        return listCity.size
    }
}