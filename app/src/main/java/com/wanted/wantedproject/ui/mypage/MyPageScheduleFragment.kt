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
import com.wanted.wantedproject.databinding.FragmentMyPageScheduleBinding

class MyPageScheduleFragment : Fragment() {

    private lateinit var binding : FragmentMyPageScheduleBinding
    private lateinit var beforeAdapter : MyClassAdapter
    private lateinit var afterAdapter : MyClassAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_my_page_schedule, container, false)
        myScheduleRecyclerViewAdapter()
        setRecyclerViewItem()
        return binding.root
    }

    private fun myScheduleRecyclerViewAdapter() {
        beforeAdapter = MyClassAdapter(requireContext())
        afterAdapter = MyClassAdapter(requireContext())
        binding.recyclerView3.adapter = afterAdapter
        binding.beforeClass.adapter = beforeAdapter
    }

    private fun setRecyclerViewItem() {
        val beforeList = arrayListOf<MyClass>()
        beforeList.add(MyClass("우디", "쿠키 원데이 클래스", "사이 기록","10/23", "","10/23" ))
        beforeList.add(MyClass("뚱이", "뚱카롱 함께 해요!", "","10/30", "","10/30" ))
        beforeAdapter.setItems(beforeList)

        val afterList = arrayListOf<MyClass>()
        afterList.add(MyClass("원츄", "즐거운 베이킹 시간 - 다함께 만들어봐요", "","11/30", "D-4","11/30" ))
        afterAdapter.setItems(afterList)

    }

}