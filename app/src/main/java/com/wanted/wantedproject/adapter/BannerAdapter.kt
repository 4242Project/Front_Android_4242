package com.wanted.wantedproject.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.wanted.wantedproject.R
import com.wanted.wantedproject.data.Banner
import com.wanted.wantedproject.databinding.ItemBannerBinding

class BannerAdapter() : RecyclerView.Adapter<BannerAdapter.BannerListViewHolder>() {
    private var bannerItem = ArrayList<Banner>()

    fun setItems(item : ArrayList<Banner>) {
        bannerItem = item
        notifyDataSetChanged()
    }

    class BannerListViewHolder(private val binding: ItemBannerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Banner) {
            binding.bannerImg.setImageResource(item.img)
           /* Glide.with(binding.root)
                .load(item.img)
                .into(binding.bannerImg)*/

            itemView.setOnClickListener {
                val webpage = Uri.parse(item.url)
                val webIntent = Intent(Intent.ACTION_VIEW,webpage)
                itemView.context.startActivity(webIntent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerListViewHolder {
        val binding = DataBindingUtil.inflate<ItemBannerBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_banner,
            parent,
            false
        )

        return BannerListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerListViewHolder, position: Int) {
        holder.bind(bannerItem[position])
    }

    override fun getItemCount() = bannerItem.size
}