package com.wanted.wantedproject.ui.home.adapter

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.view.FrameMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wanted.wantedproject.R
import com.wanted.wantedproject.data.Banner
import com.wanted.wantedproject.data.Category
import com.wanted.wantedproject.databinding.ItemBannerBinding
import com.wanted.wantedproject.databinding.ItemHomeCategoryBinding
import com.wanted.wantedproject.ui.home.ClassFragment

class CategoryAdapter() : RecyclerView.Adapter<CategoryAdapter.CategoryListViewHolder>() {
    private var categoryItem = ArrayList<Category>()

    fun setItems(item : ArrayList<Category>) {
        categoryItem = item
        notifyDataSetChanged()
    }

    class CategoryListViewHolder(private val binding: ItemHomeCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category,index : Int) {
            binding.categoryBtn.setImageResource(item.categoryImg)
            binding.categoryText.text = item.categorySubject

            itemView.setOnClickListener {
                //setStroke()
                if(index == 6)
                    Navigation.findNavController(binding.root).navigate(R.id.action_classFragment_to_anotherClassListFragment)
            }
        }


        private fun setStroke() {
            val drawable : GradientDrawable = binding.categoryBtn.background as GradientDrawable
            drawable.setStroke(16, Color.parseColor("#ff5d15"))
        }

        private fun unCheckButton() {
            val button = binding.categoryBtn
            val shape = button.background as GradientDrawable
            shape.setStroke(0, Color.parseColor("@null"))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {
        val binding = DataBindingUtil.inflate<ItemHomeCategoryBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_home_category,
            parent,
            false
        )

        return CategoryListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        holder.bind(categoryItem[position], position)

    }

    override fun getItemCount() = categoryItem.size
}