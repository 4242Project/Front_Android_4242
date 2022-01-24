package com.wanted.wantedproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.wanted.wantedproject.R
import com.wanted.wantedproject.data.Category
import com.wanted.wantedproject.databinding.ItemAllCategoryBinding

class AnotherCategoryAdapter() : RecyclerView.Adapter<AnotherCategoryAdapter.CategoryListViewHolder>() {
    private var categoryItem = ArrayList<Category>()

    fun setItems(item : ArrayList<Category>) {
        categoryItem = item
        notifyDataSetChanged()
    }

    class CategoryListViewHolder(private val binding: ItemAllCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            setNavigation(binding.root)
        }

        fun bind(item: Category) {
            binding.categoryBtn.setImageResource(item.categoryImg)
            binding.categoryText.text = item.categorySubject
        }

        private fun setNavigation(view: View) {
            view.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_anotherCategoryListFragment_to_anotherClassListFragment)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {
        val binding = DataBindingUtil.inflate<ItemAllCategoryBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_all_category,
            parent,
            false
        )

        return CategoryListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        holder.bind(categoryItem[position])
    }

    override fun getItemCount() = categoryItem.size
}