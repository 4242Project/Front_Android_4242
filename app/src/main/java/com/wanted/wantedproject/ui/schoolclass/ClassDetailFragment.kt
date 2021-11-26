package com.wanted.wantedproject.ui.schoolclass

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.core.animateFloatAsState
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.tabs.TabLayout
import com.wanted.wantedproject.R
import com.wanted.wantedproject.SaiApplication
import com.wanted.wantedproject.data.HobbyClass
import com.wanted.wantedproject.databinding.FragmentClassDetailBinding
import kotlinx.coroutines.launch

class ClassDetailFragment : Fragment() {
    private lateinit var binding : FragmentClassDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_class_detail, container,false)

        lifecycleScope.launch {
            SaiApplication.getInstance().getDataStore().setToolbarVisibility(false)
        }

        getData()
        setTabLayout()
        setNavigation()
        setImageResource()

        return binding.root
    }

    private fun getData() {
        val bundle = requireArguments().getSerializable("classInfo") as HobbyClass
        binding.classInfo = bundle
        Glide.with(binding.root).load(bundle.introduce_img_root).into(binding.classDetailImg)
    }

    private fun setTabLayout() {
        binding.classInfoTablayout.getTabAt(0)?.select()
        childFragmentManager.beginTransaction().replace(R.id.class_tab_container, ClassDetailInfoFragment()).commit()
        binding.classInfoTablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
               childFragmentManager.beginTransaction().replace(R.id.class_tab_container, ClassDetailInfoFragment()).commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }
    
    private fun setNavigation() {
        binding.studentListLayout.setOnClickListener { 
            Navigation.findNavController(binding.root).navigate(R.id.action_classDetailFragment_to_classApplicationListFragment)
            
        }
    }

    private fun setImageResource() {
        binding.includeBox.imageView4.setImageResource(R.drawable.ic_box)
        binding.includePeople.imageView4.setImageResource(R.drawable.ic_user_grey)
        binding.includeTime.imageView4.setImageResource(R.drawable.ic_time)
    }

}