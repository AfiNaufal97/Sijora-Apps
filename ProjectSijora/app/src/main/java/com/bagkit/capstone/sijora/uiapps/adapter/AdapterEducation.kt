package com.bagkit.capstone.sijora.uiapps.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bagkit.capstone.sijora.data.model.ModelEducation
import com.bagkit.capstone.sijora.databinding.ItemListBinding
import com.bagkit.capstone.sijora.uiapps.activity.detail.DetailActivity
import com.bumptech.glide.Glide


class AdapterEducation(val listEducation: ArrayList<ModelEducation>): RecyclerView.Adapter<AdapterEducation.EducationViewHolder>() {
    class EducationViewHolder(val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EducationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        holder.binding.tvTitleList.text = listEducation[position].tagName
        Glide.with(holder.itemView.context)
            .load(listEducation[position].imgEducation)
            .into(holder.binding.circleImageView2)

        holder.binding.textView3.text = listEducation[position].jumlah.toString()
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)

            intent.putExtra(DetailActivity.EXTRA_TITLE, listEducation[position].tagName)
            intent.putExtra(DetailActivity.EXTRA_COUNT, listEducation[position].jumlah.toString())

            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return listEducation.size
    }
}