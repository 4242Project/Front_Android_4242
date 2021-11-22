package com.wanted.wantedproject.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wanted.wantedproject.R
import com.wanted.wantedproject.databinding.ItemStampBinding

class MyStampAdapter(context: Context) : RecyclerView.Adapter<MyStampAdapter.StampListViewHolder>() {
    private var stampItem = listOf<String>()
    val context = context
    fun setItems(item: ArrayList<String>, userList: ArrayList<String>) {
        stampItem = userList + item
        notifyDataSetChanged()
    }

    class StampListViewHolder(private val binding: ItemStampBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String,context : Context,index :Int) {
            binding.stampSubject.text = item

            val imageKind = if(index < 5) "ic_class_${item}"
                else "ic_class_${item}_grey"
            val img = context.resources.getIdentifier(imageKind, "drawable", context.packageName)
            binding.stampImg.setImageResource(img)

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
        holder.bind(stampItem[position],context, position)
    }

    override fun getItemCount() = stampItem.size
}