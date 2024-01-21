package com.aytachuseynli.energyappui.ui.fragments

import com.aytachuseynli.energyappui.common.base.BaseFragment
import com.aytachuseynli.energyappui.data.model.FaqList
import com.aytachuseynli.energyappui.databinding.FragmentFaqPageBinding
import com.aytachuseynli.energyappui.ui.adapters.FaqAdapter


class FaqPageFragment :
    BaseFragment<FragmentFaqPageBinding>(FragmentFaqPageBinding::inflate) {

    private val faqAdapter by lazy {
        FaqAdapter()
    }

    override fun observeEvents() {

    }

    override fun onCreateFinish() {

        setAdapter()

    }

    fun setAdapter() {

        faqAdapter.submitList(
            arrayListOf(
                FaqList(
                    1,
                    "Elektrik Təchizatı şəbəkəsinə qoşulmaq üçün onlayn müraciət edə bilərəm?"
                ),
                FaqList(
                    2,
                    "Elektrik Təchizatı şəbəkəsinə qoşulmaq üçün qoşulma haqqını onlayn ödəyə bilərəm?"
                ),
                FaqList(
                    3,
                    "Elektrik Təchizatı şəbəkəsinə qoşulmaq üçün hara müraciət edə bilərəm?"
                ),
                FaqList(4, "Texniki şərt almaq üçün hansı sənədlər tələb olunur?"),
                FaqList(
                    5,
                    "Elektrik Təchizatı şəbəkəsinə qoşulmaq üçün nə qədər vəsait ödəməliyəm?"
                ),
                FaqList(6, "Texniki şərtim var güc artırmaq istəyirəm, nə etməliyəm?"),
                FaqList(
                    7,
                    "Enerji təchizatı müəssisəsi müraciətin icrasından imtina edə bilərmi?"
                ),
                FaqList(
                    8,
                    "Tikinti-quraşdırma işlərinin aparılması üçün ETM-ə qoşulma haqqından başqa əlavə vəsait ödənilirmi?"
                )
            )
        )

        binding.rvFaq.adapter = faqAdapter
    }

}