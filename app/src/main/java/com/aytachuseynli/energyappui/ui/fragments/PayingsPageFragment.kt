package com.aytachuseynli.energyappui.ui.fragments

import androidx.navigation.fragment.findNavController
import com.aytachuseynli.energyappui.common.base.BaseFragment
import com.aytachuseynli.energyappui.data.model.PaymentsList
import com.aytachuseynli.energyappui.databinding.FragmentPayingsPageBinding
import com.aytachuseynli.energyappui.ui.adapters.PaymentsAdapter


class PayingsPageFragment : BaseFragment<FragmentPayingsPageBinding>(FragmentPayingsPageBinding::inflate) {


    private val paymentsAdapter by lazy {
        PaymentsAdapter()
    }

    override fun observeEvents() {

    }

    override fun onCreateFinish() {
        setAdapter()
    }

    override fun setupListeners() {
        binding.btnAddAuto.setOnClickListener {
            findNavController().navigate(PayingsPageFragmentDirections.actionPayingsPageFragmentToSetLimitFragment())
        }
    }

    private fun setAdapter() {

        paymentsAdapter.submitList(
            arrayListOf(
                PaymentsList(1, "11.55", "30632 KW/s", "165 kW/s", "06.03.2023"),
                PaymentsList(2, "19.18", "30467 KW/s", "274 kW/s", "03.02.2023"),
                PaymentsList(3, "30.02", "30193 KW/s", "382 kW/s", "05.01.2023")
            )
        )
        binding.historyRv.adapter = paymentsAdapter

    }


}