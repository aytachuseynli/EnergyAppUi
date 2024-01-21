package com.aytachuseynli.energyappui.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aytachuseynli.energyappui.common.GenericDiffUtil
import com.aytachuseynli.energyappui.data.model.PaymentsList
import com.aytachuseynli.energyappui.databinding.ItemPayingsBinding

class PaymentsAdapter : ListAdapter<PaymentsList, PaymentsAdapter.HistoryViewHolder>(diffUtil) {

    inner class HistoryViewHolder(val binding: ItemPayingsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PaymentsList, context: Context) {
            with(binding) {
                money.text = "${item.money} Azn"
                time.text = item.time
                totalKw.text = item.totalKw
                usedKW.text = item.usedKw
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = ItemPayingsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(getItem(position), holder.itemView.context)
    }

}

private val diffUtil = GenericDiffUtil<PaymentsList>(
    myItemsTheSame = { oldItem, newItem -> oldItem.id == newItem.id },
    myContentsTheSame = { oldItem, newItem -> oldItem == newItem }
)
