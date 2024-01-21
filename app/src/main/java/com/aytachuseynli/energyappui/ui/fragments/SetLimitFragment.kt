package com.aytachuseynli.energyappui.ui.fragments


import androidx.navigation.fragment.findNavController
import com.aytachuseynli.energyappui.common.base.BaseFragment
import com.aytachuseynli.energyappui.databinding.FragmentSetLimitBinding

class SetLimitFragment : BaseFragment<FragmentSetLimitBinding>(FragmentSetLimitBinding::inflate) {

    override fun observeEvents() {
    }
    override fun onCreateFinish() {
    }
    override fun setupListeners() {
        binding.closeIcon.setOnClickListener{
            findNavController().popBackStack()
        }

    }


}