package com.wanted.wantedproject.ui.register.adapter

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
import com.wanted.wantedproject.data.StampCategory
import com.wanted.wantedproject.databinding.ItemBannerBinding
import com.wanted.wantedproject.databinding.ItemHomeCategoryBinding
import com.wanted.wantedproject.databinding.ItemStampBinding
import com.wanted.wantedproject.ui.home.ClassFragment
import com.wanted.wantedproject.ui.register.SelectStampFragment

class AfterSelectStampAdapter() : RecyclerView.Adapter<AfterSelectStampAdapter.AfterStampListViewHolder>() {
    private var categoryItem = ArrayList<StampCategory>()

    fun setItems(item : ArrayList<StampCategory>) {
        categoryItem = item
        notifyDataSetChanged()
    }

    class AfterStampListViewHolder(private val binding: ItemStampBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StampCategory) {
            binding.stampImg.setImageResource(item.categoryImg)
            binding.stampSubject.text = item.categorySubject

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AfterStampListViewHolder {
        val binding = DataBindingUtil.inflate<ItemStampBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_stamp,
            parent,
            false
        )

        return AfterStampListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AfterStampListViewHolder, position: Int) {
        holder.bind(categoryItem[position])

    }

    override fun getItemCount() = categoryItem.size
}