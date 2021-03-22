package com.dimas.alodokter.ui.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.dimas.alodokter.R
import com.dimas.alodokter.core.model.FoodHome
import com.dimas.alodokter.databinding.ItemHomeBinding
import java.util.ArrayList

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var listData = ArrayList<FoodHome>()
    var onItemClick: ((FoodHome) -> Unit)? = null

    fun setData(newListData: List<FoodHome>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder  =
        HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false))


    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemHomeBinding.bind(itemView)
        fun bind(food: FoodHome) {
            binding.itemImageHome.setImageResource(food.image)
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}