package com.wanted.wantedproject.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.wanted.wantedproject.R
import com.wanted.wantedproject.data.Week
import com.wanted.wantedproject.databinding.ItemDateBinding

class ScheduleAdapter(item : ArrayList<Week>,context : Context) : RecyclerView.Adapter<ScheduleAdapter.ScheduleListViewHolder>() {
    private val cellItem = item
    val context = context
    /*fun setItems(item : ArrayList<Banner>) {
        bannerItem = item
        notifyDataSetChanged()
    }
*/
    class ScheduleListViewHolder(private val binding: ItemDateBinding) : RecyclerView.ViewHolder(binding.root) {
        val cells = arrayListOf<View>(binding.oneCell,binding.twoCell,binding.threeCell)
        fun bind(item: Week, context: Context) {
            val time = item.endTime - item.startTime
            for( i in 0 until time)
            {
                cells[i].backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.app_main_blue))
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleListViewHolder {
        val binding = DataBindingUtil.inflate<ItemDateBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_date,
            parent,
            false
        )

        return ScheduleListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScheduleListViewHolder, position: Int) {
        holder.bind(cellItem[position],context)
    }

    override fun getItemCount() = cellItem.size
}