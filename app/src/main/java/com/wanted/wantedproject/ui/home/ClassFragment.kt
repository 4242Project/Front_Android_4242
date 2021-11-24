package com.wanted.wantedproject.ui.home

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.wanted.wantedproject.R
import com.wanted.wantedproject.SaiApplication
import com.wanted.wantedproject.data.Banner
import com.wanted.wantedproject.data.Category
import com.wanted.wantedproject.databinding.FragmentClassBinding
import com.wanted.wantedproject.ui.home.adapter.BannerAdapter
import com.wanted.wantedproject.ui.home.adapter.CategoryAdapter
import com.wanted.wantedproject.ui.category.ScheduleFragment
import kotlinx.coroutines.launch

class ClassFragment : Fragment() {
    private lateinit var binding: FragmentClassBinding
    private val bannerAdapter : BannerAdapter by lazy {
        BannerAdapter()
    }
    private val categoryAdapter : CategoryAdapter by lazy {
        CategoryAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_class, container,false)

        lifecycleScope.launch {
            SaiApplication.getInstance().getDataStore().setToolbarVisibility(true)
        }

        setCategoryFragment()
        setBannerAdapter()
        setCategoryAdapter()
        getBannerItem()
        getCategoryItem()

        return binding.root
    }

    private fun setCategoryFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.class_list_container, ScheduleFragment())
            .commit()
    }

    private fun setBannerAdapter() {
        binding.bannerRecyclerview.adapter = bannerAdapter
        binding.bannerRecyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setCategoryAdapter() {
        binding.categoryRecyclerview.adapter = categoryAdapter
        binding.categoryRecyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    }

    private fun getBannerItem() {
        val bannerList : ArrayList<Banner> = arrayListOf()
        bannerList.add(Banner(R.drawable.ic_banner, ""))
        bannerAdapter.setItems(bannerList)
    }

    //room에 저장된 데이터로 가져오기
    private fun getCategoryItem() {
        val categoryList : ArrayList<Category> = arrayListOf()
        categoryList.add(Category(R.drawable.ic_class_schedule, "시간표"))
        categoryList.add(Category(R.drawable.ic_class_baking, "베이킹"))
        categoryList.add(Category(R.drawable.ic_class_cooking, "요리"))
        categoryList.add(Category(R.drawable.ic_class_diy, "공예·만들기"))
        categoryList.add(Category(R.drawable.ic_class_e_sports, "E스포츠"))
        categoryList.add(Category(R.drawable.ic_class_it_program, "IT·프로그램"))
        categoryList.add(Category(R.drawable.ic_class_category, "더보기"))
        categoryAdapter.setItems(categoryList)
    }

     fun changeFragment(position : Int) {
        val navHostFragment = childFragmentManager.findFragmentById(R.id.class_list_container) as NavHostFragment
        val navController = navHostFragment.navController
    }

}