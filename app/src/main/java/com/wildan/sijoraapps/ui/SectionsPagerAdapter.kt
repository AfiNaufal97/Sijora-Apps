package com.wildan.sijoraapps.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wildan.sijoraapps.ui.fragment.*

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = TransportFragment()
            1 -> fragment = CityFragment()
            2 -> fragment = MedicalFragment()
            3 -> fragment = ElectricFragment()
            4 -> fragment = VoiceFragment()
            5 -> fragment = EducationFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 6
    }

}