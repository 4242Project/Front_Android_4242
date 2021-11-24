package com.wanted.wantedproject.ui.category.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.wanted.wantedproject.R
import com.wanted.wantedproject.data.MyClass
import com.wanted.wantedproject.databinding.ItemTodoBinding
import timber.log.Timber

class TodoAdapter() : RecyclerView.Adapter<TodoAdapter.ToDoListViewHolder>() {

    var itemList = arrayListOf<MyClass>()

    fun setItems(item : ArrayList<MyClass>) {
        itemList = item
        Timber.d("item${itemList.size}")
        notifyDataSetChanged()
    }

    class ToDoListViewHolder(private val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: MyClass) {
            binding.time.text = item.class_s_time + "-" + item.class_e_time
            binding.classInfo.text = item.category_name + "-" + item.class_name
            changeColorFromCategory(item.category_name)
        }

        private fun changeColorFromCategory(category : String) {
            var color = "#ffffff"
            when(category) {
                "IT·프로그램" -> {color = "#e3f2ff"}
                "공예·DIY 클래스" -> {color = "#E2F7ED"}
            }

            if(color != "#ffffff")
                binding.todoLayout.backgroundTintList = ColorStateList.valueOf(Color.parseColor(color))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoListViewHolder {
        val binding = DataBindingUtil.inflate<ItemTodoBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_todo,
            parent,
            false
        )

        return ToDoListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoListViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount() = itemList.size
}