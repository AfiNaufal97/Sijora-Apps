package com.bagkit.capstone.sijora.uiapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bagkit.capstone.sijora.backend.modeltwitter.DataTwitter
import com.bagkit.capstone.sijora.databinding.ItemListTrendingBinding
import com.bumptech.glide.Glide

class AdapterStartActivity(val dataItem:List<DataTwitter>):RecyclerView.Adapter<AdapterStartActivity.StartViewHolder>() {
    class StartViewHolder(val binding:ItemListTrendingBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(dataItemList: DataTwitter) {
            Glide.with(binding.root)
                .load("https://image.flaticon.com/icons/png/512/733/733579.png")
                .into(binding.ivTrending)

            binding.textViewTitle.text = dataItemList.text
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
       return StartViewHolder(ItemListTrendingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        val dataItemList = dataItem[position]
        holder.bind(dataItemList)
    }

    override fun getItemCount(): Int {
       return dataItem.size
    }
}