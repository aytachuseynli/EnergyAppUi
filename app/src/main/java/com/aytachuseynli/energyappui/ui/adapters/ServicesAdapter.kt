package com.aytachuseynli.energyappui.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aytachuseynli.energyappui.R
import com.aytachuseynli.energyappui.common.GenericDiffUtil
import com.aytachuseynli.energyappui.data.model.ServicesList
import com.aytachuseynli.energyappui.databinding.ItemServicesBinding
import com.bumptech.glide.Glide

class ServicesAdapter : ListAdapter<ServicesList, ServicesAdapter.ServiceViewHolder>(diffUtil) {
    inner class ServiceViewHolder(val binding: ItemServicesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ServicesList, context: Context) {

            with(binding) {
                val resourceId =
                    context.resources.getIdentifier(item.image, "drawable", context.packageName)
                Glide.with(context)
                    .load(resourceId)
                    .into(img)
                txt.text = item.text
               setBgColor(binding.bg, context, resourceId)
            }
        }

    }

    fun setBgColor(bg: CardView, context: Context, resourceId: Int) {
        val dominantColor = ContextCompat.getColor(context, R.color.red)
        val bitmap = ContextCompat.getDrawable(context, resourceId)!!.toBitmap()
        val color = Palette.from(bitmap).generate().getDominantColor(dominantColor)
        bg.setCardBackgroundColor(color)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = ItemServicesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(getItem(position), holder.itemView.context)

    }
}

private val diffUtil = GenericDiffUtil<ServicesList>(
    myItemsTheSame = { oldItem, newItem -> oldItem.id == newItem.id },
    myContentsTheSame = { oldItem, newItem -> oldItem == newItem }
)