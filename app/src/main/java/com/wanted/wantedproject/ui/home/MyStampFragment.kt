package com.wanted.wantedproject.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.wanted.wantedproject.R
import com.wanted.wantedproject.databinding.FragmentMyStampBinding
import com.wanted.wantedproject.ui.home.adapter.MyStampAdapter
import timber.log.Timber

class MyStampFragment : Fragment() {
    private lateinit var binding : FragmentMyStampBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_my_stamp, container, false)

        //myStampRecyclerViewAdapter()
        setRecyclerViewItem()

        return binding.root
    }

   /* private fun myStampRecyclerViewAdapter() {
         val adapter = MyStampAdapter(requireContext())
        binding.myStampRecyclerview.adapter = adapter
    }
*/
    private fun setRecyclerViewItem() {
        val userList = arrayListOf("baking", "sports", "it", "diy", "cooking")
        val allCategory = arrayListOf("baking", "e_sports", "it_program", "diy", "cooking","picture","talking","sports","picture","music","wine")
        val union = userList + allCategory
        val currentCategory = union.groupBy { it }.filter { it.value.size == 1 }.flatMap { it.value }
        Timber.d("category${currentCategory}")
        val adapter = MyStampAdapter(requireContext())
        binding.myStampRecyclerview.adapter = adapter
        adapter.setItems(currentCategory as ArrayList<String>, userList)


    }

}