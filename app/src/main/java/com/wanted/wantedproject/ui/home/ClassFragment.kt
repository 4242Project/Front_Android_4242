package com.wanted.wantedproject.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.wanted.wantedproject.R
import com.wanted.wantedproject.SaiApplication
import com.wanted.wantedproject.data.Banner
import com.wanted.wantedproject.data.Category
import com.wanted.wantedproject.databinding.FragmentClassBinding
import com.wanted.wantedproject.adapter.BannerAdapter
import com.wanted.wantedproject.adapter.CategoryAdapter
import com.wanted.wantedproject.ui.category.ScheduleFragment
import com.wanted.wantedproject.ui.home.category.ClassListFragment
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
        changeFragment()

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

    //room??? ????????? ???????????? ????????????
    private fun getCategoryItem() {
        val categoryList : ArrayList<Category> = arrayListOf()
        categoryList.add(Category(R.drawable.ic_class_schedule, "?????????"))
        categoryList.add(Category(R.drawable.ic_class_baking, "?????????"))
        categoryList.add(Category(R.drawable.ic_class_cooking, "??????"))
        categoryList.add(Category(R.drawable.ic_class_diy, "?????????????????"))
        categoryList.add(Category(R.drawable.ic_class_e_sports, "E?????????"))
        categoryList.add(Category(R.drawable.ic_class_it_program, "IT??????????????"))
        categoryList.add(Category(R.drawable.ic_class_category, "?????????"))
        categoryAdapter.setItems(categoryList)
    }

     fun changeFragment() {
         categoryAdapter.setItemClickListener(object : CategoryAdapter.ItemClickListener{
             override fun onClick(view: View, position: Int) {
                 when(position) {
                    0 -> {
                        childFragmentManager.beginTransaction()
                            .replace(R.id.class_list_container, ScheduleFragment())
                            .commit()
                    }
                     1 -> {
                         childFragmentManager.beginTransaction().replace(R.id.class_list_container, ClassListFragment()).commit()
                     }
                 }


             }

         })
    }



}