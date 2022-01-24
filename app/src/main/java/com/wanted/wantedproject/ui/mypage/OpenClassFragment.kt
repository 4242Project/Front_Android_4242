package com.wanted.wantedproject.ui.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.wanted.wantedproject.R
import com.wanted.wantedproject.adapter.MyClassAdapter
import com.wanted.wantedproject.data.MyClass
import com.wanted.wantedproject.databinding.FragmentOpenClassBinding

class OpenClassFragment : Fragment() {

    private lateinit var binding : FragmentOpenClassBinding
    private lateinit var adapter : MyClassAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_open_class, container, false)
        myScheduleRecyclerViewAdapter()
        setRecyclerViewItem()
        return binding.root
    }

    private fun myScheduleRecyclerViewAdapter() {
        adapter = MyClassAdapter(requireContext())
        binding.openClassRecyclerview.adapter = adapter
    }

    private fun setRecyclerViewItem() {
        val list = arrayListOf<MyClass>()
        list.add(MyClass("원티드", "달달한 초코칩 쿠기 함께 만들어요!!", "수정하기","11/25", "D-1","11/25" ))
        adapter.setItems(list)
    }



}