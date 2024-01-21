package com.aytachuseynli.energyappui.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aytachuseynli.energyappui.common.GenericDiffUtil
import com.aytachuseynli.energyappui.data.model.FaqList
import com.aytachuseynli.energyappui.databinding.ItemFaqBinding

class FaqAdapter : ListAdapter<FaqList, FaqAdapter.QuestionViewHolder>(diffUtil) {
    inner class QuestionViewHolder(val binding: ItemFaqBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FaqList, context: Context) {
            with(binding) {
                faqText.text = item.text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = ItemFaqBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(getItem(position), holder.itemView.context)
    }
}

private val diffUtil = GenericDiffUtil<FaqList>(
    myItemsTheSame = { oldItem, newItem -> oldItem.id == newItem.id },
    myContentsTheSame = { oldItem, newItem -> oldItem == newItem }
)