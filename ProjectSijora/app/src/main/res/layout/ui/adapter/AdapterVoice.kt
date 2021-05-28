package com.wildan.sijoraapps.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wildan.sijoraapps.data.model.ModelVoice
import com.wildan.sijoraapps.databinding.ItemListBinding
import com.wildan.sijoraapps.ui.activity.detail.DetailActivity

class AdapterVoice(val listVoice: ArrayList<ModelVoice>): RecyclerView.Adapter<AdapterVoice.VoiceViewHolder>() {
    class VoiceViewHolder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoiceViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VoiceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VoiceViewHolder, position: Int) {
        holder.binding.tvTitleList.text = listVoice[position].tagName
        Glide.with(holder.itemView.context)
            .load(listVoice[position].imgVoice)
            .into(holder.binding.circleImageView2)

        holder.binding.textView3.text = listVoice[position].jumlah.toString()
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)

            intent.putExtra(DetailActivity.EXTRA_TITLE, listVoice[position].tagName)
            intent.putExtra(DetailActivity.EXTRA_COUNT, listVoice[position].jumlah.toString())

            holder.itemView.context.startActivity(intent)
        }    }

    override fun getItemCount(): Int {
        return listVoice.size
    }
}