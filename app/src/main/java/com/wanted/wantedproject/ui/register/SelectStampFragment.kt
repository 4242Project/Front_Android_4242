package com.wanted.wantedproject.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.wanted.wantedproject.R
import com.wanted.wantedproject.data.Category
import com.wanted.wantedproject.data.StampCategory
import com.wanted.wantedproject.databinding.FragmentSelectStampBinding
import com.wanted.wantedproject.ui.category.adapter.AnotherCategoryAdapter
import com.wanted.wantedproject.ui.register.adapter.SelectStampAdapter

class SelectStampFragment : Fragment() {
    private lateinit var binding : FragmentSelectStampBinding
    private val adapter = SelectStampAdapter()

    companion object{
         var cnt : MutableLiveData<Int> = MutableLiveData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_select_stamp, container, false)

        categoryRecyclerViewAdapter()
        setAdapterItem()
        setNavigation()

        cnt.observe(viewLifecycleOwner, Observer {
            if(it == 5) {
                binding.completeBtn.setBackgroundResource(R.drawable.blue_select_btn_shape)
                binding.completeBtn.isEnabled = true
            }
        })

        return binding.root
    }
    private fun categoryRecyclerViewAdapter() {
        binding.myStampRecyclerview.adapter = adapter
    }

    private fun setAdapterItem() {
        cnt.value = 0
        val categoryItem = arrayListOf<StampCategory>()
        categoryItem.add(StampCategory(R.drawable.ic_class_baking, "베이킹",R.drawable.ic_class_baking_grey))
        categoryItem.add(StampCategory(R.drawable.ic_class_sports, "스포츠",R.drawable.ic_class_sports_grey))
        categoryItem.add(StampCategory(R.drawable.ic_class_it_program, "IT·프로그램",R.drawable.ic_class_it_program_grey))
        categoryItem.add(StampCategory(R.drawable.ic_class_diy, "공예·만들기",R.drawable.ic_class_diy_grey))
        categoryItem.add(StampCategory(R.drawable.ic_class_beauty_fashion, "뷰티·패션",R.drawable.ic_class_beauty_fashion_grey))
        categoryItem.add(StampCategory(R.drawable.ic_class_cooking, "요리",R.drawable.ic_class_cooking_grey))
        categoryItem.add(StampCategory(R.drawable.ic_class_talking, "회화",R.drawable.ic_class_talking_grey))
        categoryItem.add(StampCategory(R.drawable.ic_class_picture, "사진",R.drawable.ic_class_picture_grey))
        categoryItem.add(StampCategory(R.drawable.ic_class_e_sports, "E스포츠",R.drawable.ic_class_e_sports_grey))
        categoryItem.add(StampCategory(R.drawable.ic_class_music, "음악",R.drawable.ic_class_music_grey))
        categoryItem.add(StampCategory(R.drawable.ic_class_wine, "주류",R.drawable.ic_class_wine_grey))
        adapter.setItems(categoryItem)
    }

    private fun setNavigation() {
        binding.completeBtn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_selectStampFragment_to_afterSelectStampFragment)
        }
    }

}