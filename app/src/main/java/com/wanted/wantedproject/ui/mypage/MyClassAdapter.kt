package com.wanted.wantedproject.ui.mypage

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.view.FrameMetrics
import android.view.LayoutInflater
import android.view.View
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
import com.wanted.wantedproject.data.MyClass
import com.wanted.wantedproject.data.StampCategory
import com.wanted.wantedproject.databinding.ItemBannerBinding
import com.wanted.wantedproject.databinding.ItemHomeCategoryBinding
import com.wanted.wantedproject.databinding.ItemMyclassListBinding
import com.wanted.wantedproject.databinding.ItemStampBinding
import com.wanted.wantedproject.ui.home.ClassFragment
import com.wanted.wantedproject.ui.register.SelectStampFragment
import timber.log.Timber

class MyClassAdapter(context: Context) : RecyclerView.Adapter<MyClassAdapter.MyScheduelViewHolder>() {
    private var classList = ArrayList<MyClass>()
    val context = context
    fun setItems(item : ArrayList<MyClass>) {
        classList = item
        notifyDataSetChanged()
    }

    class MyScheduelViewHolder(private val binding: ItemMyclassListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyClass, context: Context) {
            binding.imageView11.background = context.resources.getDrawable(R.drawable.radius_image_background,null)
            binding.imageView11.clipToOutline = true
            if(item.class_name == "")
                binding.button12.visibility = View.INVISIBLE
            else {
                binding.button12.visibility = View.VISIBLE
                binding.button12.text = item.class_name
            }
            binding.date.text = item.class_s_time
            if(item.class_e_time == "")
                binding.ddate.visibility = View.GONE
            else {
                binding.ddate.visibility = View.VISIBLE
                binding.ddate.text = item.class_e_time
            }
            binding.subject.text = item.category_name
            binding.dep.text = item.class_id

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyScheduelViewHolder {
        val binding = DataBindingUtil.inflate<ItemMyclassListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_myclass_list,
            parent,
            false
        )

        return MyScheduelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyScheduelViewHolder, position: Int) {
        holder.bind(classList[position],context)

    }

    override fun getItemCount() = classList.size
}