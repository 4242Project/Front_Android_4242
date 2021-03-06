package com.wanted.wantedproject.adapter

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.wanted.wantedproject.R
import com.wanted.wantedproject.data.Category
import com.wanted.wantedproject.databinding.ItemHomeCategoryBinding

class CategoryAdapter() : RecyclerView.Adapter<CategoryAdapter.CategoryListViewHolder>() {
    private var categoryItem = ArrayList<Category>()

    interface ItemClickListener{
        fun onClick(view: View, position: Int)
    }
    //를릭 리스너
    private lateinit var itemClickListener: ItemClickListener
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    fun setItems(item : ArrayList<Category>) {
        categoryItem = item
        notifyDataSetChanged()
    }

    class CategoryListViewHolder(private val binding: ItemHomeCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category,index : Int) {
            binding.categoryBtn.setImageResource(item.categoryImg)
            binding.categoryText.text = item.categorySubject

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

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it,position)
        }

    }

    override fun getItemCount() = categoryItem.size
}