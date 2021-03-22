package com.dimas.alodokter.ui.main.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dimas.alodokter.R
import com.dimas.alodokter.databinding.ItemDetailBinding
import com.dimas.alodokter.databinding.ItemHomeBinding
import java.util.*

class DetailAdapter: RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    private var listData = ArrayList<String>()

    fun setData(newListData: List<String>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder  =
        DetailViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_detail,
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemDetailBinding.bind(itemView)
        fun bind(food: String) {
            Glide.with(itemView.context)
                .load(food)
                .placeholder(R.color.blueGray)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(binding.itemImageDetail)
        }
    }
}