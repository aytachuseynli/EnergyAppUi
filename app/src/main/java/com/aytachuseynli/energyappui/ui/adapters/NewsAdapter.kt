package com.aytachuseynli.energyappui.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aytachuseynli.energyappui.common.GenericDiffUtil
import com.aytachuseynli.energyappui.data.model.NewsList
import com.aytachuseynli.energyappui.databinding.ItemNewsBinding
import com.bumptech.glide.Glide

private val diffUtil = GenericDiffUtil<NewsList>(
    myItemsTheSame = { oldItem, newItem -> oldItem.id == newItem.id },
    myContentsTheSame = { oldItem, newItem -> oldItem == newItem }
)
class NewsAdapter : ListAdapter<NewsList, NewsAdapter.NewsViewHolder>(diffUtil) {

    inner class NewsViewHolder(val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NewsList, context: Context) {

            with(binding) {
                val resourceId =
                    context.resources.getIdentifier(item.image, "drawable", context.packageName)
                Glide.with(context)
                    .load(resourceId)
                    .into(newsImage)

                newsText.text = item.text
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position), holder.itemView.context)
    }
}
