package com.aytachuseynli.energyappui.ui.fragments.AnalysisPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aytachuseynli.energyappui.common.base.BaseFragment
import com.aytachuseynli.energyappui.databinding.FragmentAnalysisPageBinding
import com.google.android.material.tabs.TabLayoutMediator

class AnalysisPageFragment :
    BaseFragment<FragmentAnalysisPageBinding>(FragmentAnalysisPageBinding::inflate) {

    private val fragmentList = ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentList.add(DailyFragment())
        fragmentList.add(MonthlyFragment())

        fragmentTitleList.add("Daily")
        fragmentTitleList.add("Monthly")
    }

    inner class MyViewPagerAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }
    }

    private fun setTabLayoutManager() {
        val adapter = MyViewPagerAdapter(requireActivity())
        binding.viewpager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewpager) { tab, position ->
            tab.text = fragmentTitleList[position]

        }.attach()
    }

    override fun observeEvents() {
    }

    override fun onCreateFinish() {
        setTabLayoutManager()

    }

}