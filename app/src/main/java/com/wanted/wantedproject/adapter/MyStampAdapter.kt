package com.wanted.wantedproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.wanted.wantedproject.R
import com.wanted.wantedproject.data.StampInfo
import com.wanted.wantedproject.databinding.ItemMystampBinding

class MyStampAdapter(context: Context) : RecyclerView.Adapter<MyStampAdapter.StampListViewHolder>() {
    private var stampItem = listOf<StampInfo>()
    val context = context
    fun setItems(item: ArrayList<StampInfo>) {
        stampItem = item
        notifyDataSetChanged()
    }

    class StampListViewHolder(private val binding: ItemMystampBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StampInfo ,context : Context,index :Int) {
            binding.stampSubject.text = changeKorea(item.category)

            if(item.stampCnt == 0)
                binding.badgeCnt.visibility = View.INVISIBLE
            else {
                binding.badgeCnt.visibility = View.VISIBLE
                binding.badgeCnt.text = item.stampCnt.toString()
            }

            val imageKind = if(index < 5) "ic_class_${item.category}"
                else "ic_class_${item.category}_grey"
            val img = context.resources.getIdentifier(imageKind, "drawable", context.packageName)
            binding.stampImg.setImageResource(img)

        }

        private fun changeKorea(category: String) : String {
            var transText = ""
            when(category) {
                "baking" -> transText = "베이킹"
                "e_sports" -> transText = "E스포츠"
                "it_program" -> transText = "IT·프로그램"
                "diy" -> transText = "공예·만들기"
                "cooking" -> transText = "요리"
                "picture" -> transText = "사진"
                "talking" -> transText = "회화"
                "sports" -> transText = "스포츠"
                "beauty_fashion" -> transText = "뷰티·패션"
                "music" -> transText = "음악"
                "wine" -> transText = "주류"
            }
            return transText
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StampListViewHolder {
        val binding = DataBindingUtil.inflate<ItemMystampBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_mystamp,
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