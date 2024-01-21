package com.aytachuseynli.energyappui.ui.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aytachuseynli.energyappui.common.GenericDiffUtil
import com.aytachuseynli.energyappui.data.model.EnergyList
import com.aytachuseynli.energyappui.databinding.ItemEnergyBinding
import com.bumptech.glide.Glide
import android.view.ViewGroup

private val diffUtil = GenericDiffUtil<EnergyList>(
    myItemsTheSame = { oldItem, newItem -> oldItem.id == newItem.id },
    myContentsTheSame = { oldItem, newItem -> oldItem == newItem }
)
class EnergyAdapter: ListAdapter<EnergyList, EnergyAdapter.HomeViewHolder>(diffUtil) {
    inner class HomeViewHolder(val binding: ItemEnergyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EnergyList,context:Context){

            with(binding){
                val resourceId = context.resources.getIdentifier(item.image, "drawable", context.packageName)
                Glide.with(context)
                    .load(resourceId)
                    .into(icon)
                homeItem.setCardBackgroundColor(Color.parseColor(item.color))
                txt.text=item.text
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = ItemEnergyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position),holder.itemView.context)
    }


}