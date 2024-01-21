package com.aytachuseynli.energyappui.ui.fragments

import android.graphics.Color
import com.aytachuseynli.energyappui.common.base.BaseFragment
import com.aytachuseynli.energyappui.data.model.EnergyList
import com.aytachuseynli.energyappui.data.model.NewsList
import com.aytachuseynli.energyappui.databinding.FragmentHomePageBinding
import com.aytachuseynli.energyappui.ui.adapters.EnergyAdapter
import com.aytachuseynli.energyappui.ui.adapters.NewsAdapter

class HomePageFragment : BaseFragment<FragmentHomePageBinding> (FragmentHomePageBinding::inflate) {

    private val energyAdapter by lazy {
        EnergyAdapter()
    }
    private val newsAdapter by lazy {
        NewsAdapter()
    }
    override fun observeEvents() {

    }
    override fun onCreateFinish() {
        setAdapters()
    }
    private fun setAdapters(){
        energyAdapter.submitList(arrayListOf(
            EnergyList(1,"increase_icon","Ortalama enerji İstehlakı", "#294D8C"),
            EnergyList(2,"square_icon","Add auto Top-Up","#A8C5B7"),
            EnergyList(3,"energy_icon","Enerjiyə qənaət məsləhətləri","#EA5455")))

        newsAdapter.submitList(arrayListOf(
            NewsList(1,"news1_image","Prezident İlham Əliyev Mingəçevir şəhərinin elektrik paylayıcı şəbəkəsinin Avtomatik İdarəetmə..."),
            NewsList(2,"news2_image","Ağcabədinin Pərioğullar və Hacıbədəlli kəndlərinin elektrik şəbəkəsi yenidən qurulur."),
            NewsList(3,"news1_image","Ağcabədinin Pərioğullar və Hacıbədəlli kəndlərinin elektrik şəbəkəsi yenidən qurulur.")
        ))

        binding.rvEnergy.adapter=energyAdapter
        binding.rvNews.adapter=newsAdapter
    }

}