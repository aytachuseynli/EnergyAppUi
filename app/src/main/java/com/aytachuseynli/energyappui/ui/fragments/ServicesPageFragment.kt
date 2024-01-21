package com.aytachuseynli.energyappui.ui.fragments

import com.aytachuseynli.energyappui.common.base.BaseFragment
import com.aytachuseynli.energyappui.data.model.ServicesList
import com.aytachuseynli.energyappui.databinding.FragmentServicesPageBinding
import com.aytachuseynli.energyappui.ui.adapters.ServicesAdapter


class ServicesPageFragment : BaseFragment<FragmentServicesPageBinding>(FragmentServicesPageBinding::inflate) {

    private lateinit var serviceAdapter: ServicesAdapter

    override fun observeEvents() {
    }

    override fun onCreateFinish() {
        serviceAdapter = ServicesAdapter()

        serviceAdapter.submitList(
            arrayListOf(
                ServicesList(1, "Əhali abonentinin enerji təchizatı şəbəkəsinə qoşulması", "document_icon"),
                ServicesList(2, "Qoşulma Haqqının Onlayn Ödəlməsi", "qosulma"),
                ServicesList(4, "Borcun araşdırılması və borcun olmaması (və ya olması) barədə sənədin verilməsi", "payment_icon"),
                ServicesList(3, "Kalkulyatorlar", "calculate_icon"),
                ServicesList(5, "Əhali istehlakçısının ad dəyişdirilməsi", "print_icon"),
                ServicesList(6, "Abonentin geniş tarixçəsinin verilməsi", "note_icon"),
                ServicesList(7, "Yük hesabatının hazırlanması", "process_icon"),
                ServicesList(8, "İstehlakçının balansında olan elektrik şəbəkələrinə və avadanlıqlarına texniki xidmətin göstərilməsi", "table_icon")
            )
        )
        setAdapter()
    }

    private fun setAdapter() {
        binding.serviceRv.adapter = serviceAdapter
    }

}