package com.wanted.wantedproject.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.wanted.wantedproject.R
import com.wanted.wantedproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container,false)

        setNavFragment(ClassFragment())


        return binding.root
    }


    private fun setNavFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.home_container_fragment, fragment)
            .commit()
    }

}