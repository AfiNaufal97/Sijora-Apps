package com.bagkit.capstone.sijora.uiapps.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bagkit.capstone.sijora.data.model.ModelElectric
import com.bagkit.capstone.sijora.databinding.ItemListBinding
import com.bagkit.capstone.sijora.uiapps.activity.detail.DetailActivity
import com.bumptech.glide.Glide


class AdapterElectric(val listElectric: ArrayList<ModelElectric>): RecyclerView.Adapter<AdapterElectric.ElectricViewHolder>() {
    class ElectricViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElectricViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ElectricViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ElectricViewHolder, position: Int) {
        holder.binding.tvTitleList.text = listElectric[position].tagName
        Glide.with(holder.itemView.context)
            .load(listElectric[position].imgElectric)
            .into(holder.binding.circleImageView2)

        holder.binding.textView3.text = listElectric[position].jumlah.toString()
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)

            intent.putExtra(DetailActivity.EXTRA_TITLE, listElectric[position].tagName)
            intent.putExtra(DetailActivity.EXTRA_COUNT, listElectric[position].jumlah.toString())

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listElectric.size
    }
}