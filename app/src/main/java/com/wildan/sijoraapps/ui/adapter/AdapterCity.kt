package com.wildan.sijoraapps.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wildan.sijoraapps.data.ModelCity
import com.wildan.sijoraapps.databinding.FragmentCityBinding
import com.wildan.sijoraapps.databinding.ItemListBinding

class AdapterCity(val listCity: ArrayList<ModelCity> ): RecyclerView.Adapter<AdapterCity.CityViewHolder>() {
    inner class CityViewHolder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.binding.tvTitleList.text = listCity[position].tagName
        Glide.with(holder.itemView.context)
            .load(listCity[position].imgCity)
            .into(holder.binding.circleImageView2)

        holder.binding.textView3.text = listCity[position].jumlah.toString()
    }

    override fun getItemCount(): Int {
        return listCity.size
    }
}