package com.wanted.wantedproject.ui.category.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.geometry.CornerRadius
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.wanted.wantedproject.R
import com.wanted.wantedproject.data.Category
import com.wanted.wantedproject.data.HobbyClass
import com.wanted.wantedproject.databinding.ItemAllCategoryBinding
import com.wanted.wantedproject.databinding.ItemClassListBinding
import com.wanted.wantedproject.databinding.ItemHomeCategoryBinding
import timber.log.Timber
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class AnotherClassAdapter(frag : Int) : RecyclerView.Adapter<AnotherClassAdapter.ClassListViewHolder>() {
    private var classList = ArrayList<HobbyClass>()
    private val frag = frag
    fun setItems(item : ArrayList<HobbyClass>) {
        classList = item
        notifyDataSetChanged()
    }

    class ClassListViewHolder(private val binding: ItemClassListBinding,frag: Int) : RecyclerView.ViewHolder(binding.root) {
        init {
            setNavigation(binding.root,frag)
        }
        @SuppressLint("SetTextI18n")
        fun bind(item: HobbyClass) {
            binding.classInfo = item
            val dec = DecimalFormat("#,###")
            binding.classFee.text = dec.format(item.fee).toString()
            binding.saiProgressBar.progress = item.sai__change_
            binding.classDate.text = "D-" + calDate(item.start_date).toString()

            Glide.with(binding.root).load(item.introduce_img_root).apply(RequestOptions().transform(
                RoundedCorners(16)
            )).into(binding.imageView)

        }

        private fun setNavigation(view: View,frag: Int) {

            view.setOnClickListener {
                val bundle = Bundle()
                bundle.putSerializable("classInfo", binding.classInfo)
                when(frag) {
                    0 -> Navigation.findNavController(view).navigate(
                        R.id.action_classFragment_to_classDetailFragment,
                        bundle)
                    1 -> Navigation.findNavController(view).navigate(
                        R.id.action_anotherClassListFragment_to_classDetailFragment,
                        bundle)
                }
            }
        }

        @SuppressLint("SimpleDateFormat")
        private fun calDate(classDate : String): Long {
            val today = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, 0)
                set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }.time.time
            val time = "$classDate 00:00:00"
            val sf = SimpleDateFormat("yyyy-MM-dd 00:00:00")
            val sfDate = sf.parse(time)
            val dDay = (sfDate.time - today) / (60 * 60 * 24 * 1000)
            return dDay
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassListViewHolder {
        val binding = DataBindingUtil.inflate<ItemClassListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_class_list,
            parent,
            false
        )

        return ClassListViewHolder(binding,frag)
    }

    override fun onBindViewHolder(holder: ClassListViewHolder, position: Int) {
        holder.bind(classList[position])
    }

    override fun getItemCount() = classList.size
}