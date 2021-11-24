package com.wanted.wantedproject.ui.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayout
import com.wanted.wantedproject.R
import com.wanted.wantedproject.SaiApplication
import com.wanted.wantedproject.databinding.FragmentMyPageBinding
import kotlinx.coroutines.launch
import java.util.*

class MyPageFragment : Fragment() {
    private lateinit var binding : FragmentMyPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_my_page, container, false)

        lifecycleScope.launch {
            SaiApplication.getInstance().getDataStore().setToolbarVisibility(false)
        }

        changeTabEvent()

        return binding.root
    }

    private fun changeTabEvent(){
        binding.mypageTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab!!.position) {
                    0 -> {replaceTabFragment(MyPageScheduleFragment())}
                    1 -> {replaceTabFragment(OpenClassFragment())}
                }

            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun replaceTabFragment(fragment : Fragment) {
        childFragmentManager.beginTransaction().replace(R.id.tab_container, fragment).commit()
    }

}