package com.bagkit.capstone.sijora.uiapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bagkit.capstone.sijora.databinding.ItemList2Binding
import com.bagkit.capstone.sijora.register.model.DataQueryTag

class AdapterHome(val data:ArrayList<DataQueryTag>):RecyclerView.Adapter<AdapterHome.HomeViewHolder>(){

    lateinit var getDataHastag:SetDataHashtag

    interface SetDataHashtag {
        fun setDataHastag(data:DataQueryTag)
    }

    fun setValueHashtag(getDataHashtag: SetDataHashtag){
        this.getDataHastag = getDataHashtag
    }

    inner class HomeViewHolder(val binding:ItemList2Binding):RecyclerView.ViewHolder(binding.root) {
        fun bind(dataListHastag: DataQueryTag) {
            binding.textViewTitle.text = dataListHastag.nameTag
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