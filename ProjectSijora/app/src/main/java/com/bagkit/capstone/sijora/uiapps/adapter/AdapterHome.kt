package com.bagkit.capstone.sijora.uiapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bagkit.capstone.sijora.backend.modelapi.DataSijora
import com.bagkit.capstone.sijora.databinding.ItemList2Binding
import com.bumptech.glide.Glide

class AdapterHome(val data:List<DataSijora>):RecyclerView.Adapter<AdapterHome.HomeViewHolder>(){

    lateinit var getDataHastag:SetDataHashtag

    interface SetDataHashtag {
        fun setDataHastag(data: DataSijora)
    }

    fun setValueHashtag(getDataHashtag: SetDataHashtag){
        this.getDataHastag = getDataHashtag
    }

    inner class HomeViewHolder(val binding:ItemList2Binding):RecyclerView.ViewHolder(binding.root) {
        fun bind(dataListHastag: DataSijora) {
            Glide.with(binding.root)
                .load("https://image.flaticon.com/icons/png/512/2946/2946209.png")
                .into(binding.ivInput)
            binding.textViewTitle.text = dataListHastag.input_mobile
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(ItemList2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
       val dataListHastag = data[position]
        holder.bind(dataListHastag)
        holder.itemView.setOnClickListener {
            getDataHastag.setDataHastag(dataListHastag)
        }
    }

    override fun getItemCount(): Int {
       return data.size
    }


}