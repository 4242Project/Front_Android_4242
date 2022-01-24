package com.wanted.wantedproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.wanted.wantedproject.R
import com.wanted.wantedproject.data.StampCategory
import com.wanted.wantedproject.databinding.ItemStampBinding
import com.wanted.wantedproject.ui.register.SelectStampFragment

class SelectStampAdapter() : RecyclerView.Adapter<SelectStampAdapter.SelectStampListViewHolder>() {
    private var categoryItem = ArrayList<StampCategory>()

    fun setItems(item : ArrayList<StampCategory>) {
        categoryItem = item
        notifyDataSetChanged()
    }

    class SelectStampListViewHolder(private val binding: ItemStampBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StampCategory) {
            binding.stampImg.setImageResource(item.imgName)
            binding.stampSubject.text = item.categorySubject

            itemView.setOnClickListener {
                binding.stampImg.setImageResource(item.categoryImg)
                SelectStampFragment.cnt.value = SelectStampFragment.cnt.value?.plus(1)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectStampListViewHolder {
        val binding = DataBindingUtil.inflate<ItemStampBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_stamp,
            parent,
            false
        )

        return SelectStampListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectStampListViewHolder, position: Int) {
        holder.bind(categoryItem[position])

    }

    override fun getItemCount() = categoryItem.size
}