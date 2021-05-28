package com.bagkit.capstone.sijora.uiapps.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bagkit.capstone.sijora.data.model.ModelTransportation
import com.bagkit.capstone.sijora.databinding.ItemListBinding
import com.bagkit.capstone.sijora.uiapps.activity.detail.DetailActivity
import com.bumptech.glide.Glide


class AdapterTransportation(val listTransportation: ArrayList<ModelTransportation>): RecyclerView.Adapter<AdapterTransportation.TransportationViewModel>() {
    class TransportationViewModel(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransportationViewModel {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransportationViewModel(binding)
    }

    override fun onBindViewHolder(holder: TransportationViewModel, position: Int) {
        holder.binding.tvTitleList.text = listTransportation[position].tagName
        Glide.with(holder.itemView.context)
            .load(listTransportation[position].imgTransportation)
            .into(holder.binding.circleImageView2)

        holder.binding.textView3.text = listTransportation[position].jumlah.toString()
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)

            intent.putExtra(DetailActivity.EXTRA_TITLE, listTransportation[position].tagName)
            intent.putExtra(DetailActivity.EXTRA_COUNT, listTransportation[position].jumlah.toString())

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listTransportation.size
    }
}