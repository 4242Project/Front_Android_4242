package com.wanted.wantedproject.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.wanted.wantedproject.R
import com.wanted.wantedproject.SaiApplication
import com.wanted.wantedproject.data.Category
import com.wanted.wantedproject.databinding.FragmentAnotherCategoryListBinding
import com.wanted.wantedproject.databinding.FragmentAnotherClassListBinding
import com.wanted.wantedproject.ui.category.adapter.AnotherCategoryAdapter
import kotlinx.coroutines.launch

class AnotherCategoryListFragment : Fragment() {
    private lateinit var binding : FragmentAnotherCategoryListBinding
    private val adapter = AnotherCategoryAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_another_category_list, container, false)

        lifecycleScope.launch {
            SaiApplication.getInstance().getDataStore().setToolbarVisibility(false)
        }

        categoryRecyclerViewAdapter()
        setCategoryItem()
        setOnClickEvent()

        return binding.root
    }

    private fun setOnClickEvent() {
        binding.toolBar.arrowBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun categoryRecyclerViewAdapter() {
        binding.anotherCategoryRecyclerview.adapter = adapter
    }

    private fun setCategoryItem() {
        val categoryItem = arrayListOf<Category>()
        categoryItem.add(Category(R.drawable.ic_class_baking, "베이킹"))
        categoryItem.add(Category(R.drawable.ic_class_sports, "스포츠"))
        categoryItem.add(Category(R.drawable.ic_class_it_program, "IT·프로그램"))
        categoryItem.add(Category(R.drawable.ic_class_diy, "공예·만들기"))
        categoryItem.add(Category(R.drawable.ic_class_beauty_fashion, "뷰티·패션"))
        categoryItem.add(Category(R.drawable.ic_class_cooking, "요리"))
        categoryItem.add(Category(R.drawable.ic_class_talking, "회화"))
        categoryItem.add(Category(R.drawable.ic_class_picture, "사진"))
        categoryItem.add(Category(R.drawable.ic_class_e_sports, "E스포츠"))
        categoryItem.add(Category(R.drawable.ic_class_music, "음악"))
        categoryItem.add(Category(R.drawable.ic_class_wine, "주류"))
        adapter.setItems(categoryItem)

    }
}