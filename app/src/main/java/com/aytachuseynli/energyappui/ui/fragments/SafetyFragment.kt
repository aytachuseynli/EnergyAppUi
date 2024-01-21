package com.aytachuseynli.energyappui.ui.fragments

import com.aytachuseynli.energyappui.common.base.BaseFragment
import com.aytachuseynli.energyappui.databinding.FragmentSafetyBinding


class SafetyFragment : BaseFragment<FragmentSafetyBinding>(FragmentSafetyBinding::inflate) {


    override fun observeEvents() {

    }

    override fun onCreateFinish() {
        binding.webview.settings.javaScriptEnabled = true
        binding.webview.loadUrl("https://www.google.com/?hl=tr")

    }


}