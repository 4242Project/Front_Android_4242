package com.wanted.wantedproject.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.wanted.wantedproject.R
import com.wanted.wantedproject.databinding.FragmentMyStampBinding
import timber.log.Timber

class MyStampFragment : Fragment() {
    private lateinit var binding : FragmentMyStampBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_my_stamp, container, false)
        setRecyclerViewItem()
        return binding.root
    }

    private fun myStampRecyclerViewAdapter() {

    }

    private fun setRecyclerViewItem() {
        val userList = arrayListOf("baking", "sports", "it", "diy", "cooking")
        val allCategory = arrayListOf("baking", "sports", "it", "diy", "cooking","beauty","talking","esports","picture","music","wine")

        for(i in 0..userList.size){
            allCategory.filter {
                it != userList[i]
            }
        }

        Timber.d("category${allCategory}")


    }

}