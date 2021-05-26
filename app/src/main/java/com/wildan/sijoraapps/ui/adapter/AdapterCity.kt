package com.wildan.sijoraapps.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wildan.sijoraapps.data.ModelCity
import com.wildan.sijoraapps.databinding.FragmentCityBinding
import com.wildan.sijoraapps.databinding.ItemListBinding
import com.wildan.sijoraapps.ui.activity.detail.DetailActivity

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
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)

            intent.putExtra(DetailActivity.EXTRA_TITLE, listCity[position].tagName)
            intent.putExtra(DetailActivity.EXTRA_COUNT, listCity[position].jumlah.toString())

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listCity.size
    }
}