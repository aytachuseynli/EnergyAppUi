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
                ServicesList(2, "Qoşulma Haqqının Onlayn Ödəlməsi", "payment_icon"),
                ServicesList(4, "Borcun araşdırılması və borcun olmaması (və ya olması) barədə sənədin verilməsi", "print_icon"),
                ServicesList(3, "Kalkulyatorlar", "calculate_icon"),
                ServicesList(5, "Əhali istehlakçısının ad dəyişdirilməsi", "note_icon"),
                ServicesList(6, "Abonentin geniş tarixçəsinin verilməsi", "process_icon"),
                ServicesList(7, "Yük hesabatının hazırlanması", "table_icon"),
                ServicesList(8, "İstehlakçının balansında olan elektrik şəbəkələrinə və avadanlıqlarına texniki xidmətin göstərilməsi", "connect_icon"),
                ServicesList(9, "Elektrik təchizatı sistemlərinin layihələndirilməsi və quraşdırılma işləri", "list_icon"),
                ServicesList(10, "Abonent kodunun PASSİV və AKTİV olunması üçün müraciətlərin qəbulu", "activate_icon"),
                ServicesList(11, "Çoxmənzilli binalarda yaşayış mənzillərinin qeydiyyata alınması", "register_icon"),
                ServicesList(12, "Məcburi köçkün qrupuna aid abonentlərdən müraciətlərin qəbulu", "appeal_icon")
            )
        )
        setAdapter()
    }

    private fun setAdapter() {
        binding.serviceRv.adapter = serviceAdapter
    }

}