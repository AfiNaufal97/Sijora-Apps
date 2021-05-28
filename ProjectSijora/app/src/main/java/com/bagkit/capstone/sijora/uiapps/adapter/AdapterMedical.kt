package com.bagkit.capstone.sijora.uiapps.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bagkit.capstone.sijora.data.model.ModelMedical
import com.bagkit.capstone.sijora.databinding.ItemListBinding
import com.bagkit.capstone.sijora.uiapps.activity.detail.DetailActivity
import com.bumptech.glide.Glide

class AdapterMedical(val listMedical: ArrayList<ModelMedical>): RecyclerView.Adapter<AdapterMedical.MedicalViewHolder>() {
    class MedicalViewHolder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicalViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MedicalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MedicalViewHolder, position: Int) {
        holder.binding.tvTitleList.text = listMedical[position].tagName
        Glide.with(holder.itemView.context)
            .load(listMedical[position].imgMedical)
            .into(holder.binding.circleImageView2)

        holder.binding.textView3.text = listMedical[position].jumlah.toString()
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)

            intent.putExtra(DetailActivity.EXTRA_TITLE, listMedical[position].tagName)
            intent.putExtra(DetailActivity.EXTRA_COUNT, listMedical[position].jumlah.toString())

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listMedical.size
    }
}