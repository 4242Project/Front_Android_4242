package com.wanted.wantedproject.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.wanted.wantedproject.R
import com.wanted.wantedproject.SaiApplication
import com.wanted.wantedproject.data.StampInfo
import com.wanted.wantedproject.databinding.FragmentMyStampBinding
import com.wanted.wantedproject.adapter.MyStampAdapter
import kotlinx.coroutines.launch

class MyStampFragment : Fragment() {
    private lateinit var binding : FragmentMyStampBinding
    private lateinit var adapter: MyStampAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_my_stamp, container, false)

        lifecycleScope.launch {
            SaiApplication.getInstance().getDataStore().setToolbarVisibility(true)
        }

        myStampRecyclerViewAdapter()
        setRecyclerViewItem()

        return binding.root
    }

    private fun myStampRecyclerViewAdapter() {
        adapter = MyStampAdapter(requireContext())
        binding.myStampRecyclerview.adapter = adapter
    }

    private fun setRecyclerViewItem() {
        val userList = arrayListOf("baking", "sports", "it_program", "diy", "cooking")
        val allCategory = arrayListOf("baking", "e_sports", "it_program", "diy", "cooking","picture","talking","sports","beauty_fashion","music","wine")
        val union = allCategory + userList
        val currentCategory = union.groupBy { it }.filter { it.value.size == 1 }.flatMap { it.value }
        val resultArray = userList + currentCategory as ArrayList<String>
        val countArray = arrayListOf(8,3,2,1,1,0,0,1,0,0,0)

        val stampInfoList = arrayListOf<StampInfo>()
        for(i in resultArray.indices) {
            stampInfoList.add(StampInfo(resultArray[i],countArray[i]))
        }
        adapter.setItems(stampInfoList)
    }

}