package com.wanted.wantedproject.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.wanted.wantedproject.R
import com.wanted.wantedproject.data.StampCategory
import com.wanted.wantedproject.databinding.FragmentAfterSelectStampBinding
import com.wanted.wantedproject.databinding.FragmentSelectStampBinding
import com.wanted.wantedproject.ui.register.adapter.AfterSelectStampAdapter
import com.wanted.wantedproject.ui.register.adapter.SelectStampAdapter

class AfterSelectStampFragment : Fragment() {
    private lateinit var binding : FragmentAfterSelectStampBinding
    private val adapter = AfterSelectStampAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_after_select_stamp, container, false)

        categoryRecyclerViewAdapter()
        setAdapterItem()
        setNavigation()

        return binding.root
    }
    private fun categoryRecyclerViewAdapter() {
        binding.selectStampRecyclerview.adapter = adapter
    }

    private fun setAdapterItem() {
        val categoryItem = arrayListOf<StampCategory>()
        categoryItem.add(StampCategory(R.drawable.ic_class_baking, "베이킹",R.drawable.ic_class_baking_grey))
        categoryItem.add(StampCategory(R.drawable.ic_class_sports, "스포츠",R.drawable.ic_class_sports_grey))
        categoryItem.add(StampCategory(R.drawable.ic_class_it_program, "IT·프로그램",R.drawable.ic_class_it_program_grey))
        categoryItem.add(StampCategory(R.drawable.ic_class_diy, "공예·만들기",R.drawable.ic_class_diy_grey))
        categoryItem.add(StampCategory(R.drawable.ic_class_beauty_fashion, "뷰티·패션",R.drawable.ic_class_beauty_fashion_grey))
        adapter.setItems(categoryItem)
    }

    private fun setNavigation() {
        binding.startBtn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_global_classFragment)
        }
    }
}