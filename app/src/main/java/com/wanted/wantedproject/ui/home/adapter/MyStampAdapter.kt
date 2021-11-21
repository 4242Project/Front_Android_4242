package com.wanted.wantedproject.ui.home.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wanted.wantedproject.R
import com.wanted.wantedproject.data.Banner
import com.wanted.wantedproject.data.Category
import com.wanted.wantedproject.databinding.ItemBannerBinding
import com.wanted.wantedproject.databinding.ItemHomeCategoryBinding
import com.wanted.wantedproject.databinding.ItemStampBinding

class MyStampAdapter() : RecyclerView.Adapter<MyStampAdapter.StampListViewHolder>() {
    private var stampItem = ArrayList<Category>()

    fun setItems(item : ArrayList<Category>) {
        stampItem = item
        notifyDataSetChanged()
    }

    class StampListViewHolder(private val binding: ItemStampBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StampListViewHolder {
        val binding = DataBindingUtil.inflate<ItemStampBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_stamp,
            parent,
            false
        )

        return StampListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StampListViewHolder, position: Int) {
        holder.bind(stampItem[position])
    }

    override fun getItemCount() = stampItem.size
}