package com.aytachuseynli.energyappui.ui.fragments

import androidx.navigation.fragment.findNavController
import com.aytachuseynli.energyappui.common.base.BaseFragment
import com.aytachuseynli.energyappui.databinding.FragmentMorePageBinding


class MorePageFragment : BaseFragment<FragmentMorePageBinding>(FragmentMorePageBinding::inflate) {

    override fun observeEvents() {
    }

    override fun onCreateFinish() {
    }

    override fun setupListeners() {
        with(binding) {
            btnQuestion.setOnClickListener {
                findNavController().navigate(MorePageFragmentDirections.actionMorePageFragmentToFaqPageFragment())
            }
            btnDanger.setOnClickListener {
                findNavController().navigate(MorePageFragmentDirections.toSafety())
            }
        }

    }

}