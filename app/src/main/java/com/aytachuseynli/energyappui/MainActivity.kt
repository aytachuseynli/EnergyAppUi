package com.aytachuseynli.energyappui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.aytachuseynli.energyappui.common.utils.Extensions.goneEach
import com.aytachuseynli.energyappui.common.utils.Extensions.visible
import com.aytachuseynli.energyappui.common.utils.Extensions.visibleEach
import com.aytachuseynli.energyappui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomMenu, navController)

        binding.bottomMenu.menu
        binding.bottomMenu.setOnItemSelectedListener {
            NavigationUI.onNavDestinationSelected(it,navController)
            true
        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            with(binding){
                when (destination.id) {
                    R.id.fragmentProfile->{
                        listOf(homeHeader,bottomMenu).goneEach()
                        profileHeader.visible()
                    }
                    R.id.homePageFragment->{
                        listOf(homeHeader,bottomMenu,welcome,mainPageText).visibleEach()
                        listOf(profileHeader,serviceTxt).goneEach()
                    }
                    R.id.servicesPageFragment->{
                        listOf(homeHeader,bottomMenu,serviceTxt).visibleEach()
                        listOf(profileHeader,welcome,mainPageText).goneEach()
                        serviceTxt.text=resources.getString(R.string.services)
                    }
                    R.id.morePageFragment->{
                        listOf(homeHeader,bottomMenu,serviceTxt).visibleEach()
                        listOf(profileHeader,welcome,mainPageText).goneEach()
                        serviceTxt.text=resources.getString(R.string.questions)
                    }
                    R.id.toFaq->{

                        listOf(homeHeader,bottomMenu,serviceTxt).visibleEach()
                        listOf(profileHeader,welcome,mainPageText).goneEach()
                        serviceTxt.text=resources.getString(R.string.more)
                    }
                    R.id.payingsPageFragment->{
                        listOf(homeHeader,bottomMenu,serviceTxt).visibleEach()
                        listOf(profileHeader,welcome,mainPageText).goneEach()
                        serviceTxt.text=resources.getString(R.string.payments)
                    }
                    R.id.analysisPageFragment->{
                        listOf(homeHeader,bottomMenu,serviceTxt).visibleEach()
                        listOf(profileHeader,welcome,mainPageText).goneEach()
                        serviceTxt.text=resources.getString(R.string.analys_view)
                    }
                    R.id.safetyFragment->{
                        listOf(homeHeader,serviceTxt).visibleEach()
                        listOf(profileHeader,bottomMenu,welcome,mainPageText).goneEach()
                        serviceTxt.text=resources.getString(R.string.safety_rules)
                    }
                    R.id.setLimitFragment->{
                        listOf(homeHeader,bottomMenu).goneEach()
                    }
                    else -> { binding.bottomMenu.visible()}
                }
            }
        }
        binding.profileIc.setOnClickListener {
            navController.navigate(R.id.fragmentProfile)
        }
        binding.btnBack.setOnClickListener{
            navController.popBackStack()
        }
    }
}