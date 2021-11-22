package com.wanted.wantedproject.ui.category

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.RadioGroup
import androidx.core.view.marginTop
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.wanted.wantedproject.R
import com.wanted.wantedproject.data.Week
import com.wanted.wantedproject.databinding.FragmentScheduleBinding
import com.wanted.wantedproject.ui.category.adapter.ScheduleAdapter

class ScheduleFragment : Fragment() {
    private lateinit var binding : FragmentScheduleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_schedule, container,false)

        setScheduleAdapter()

        return binding.root
    }

    private fun setScheduleAdapter(){
        val mondayItem = Week(9,12, "베이킹 클래스")
        val fridayItem = Week(12,15, "축구 클래스")
        val scheduleItem = arrayListOf<Week>(mondayItem,fridayItem,mondayItem,fridayItem,mondayItem,fridayItem,mondayItem)
        val adapter = ScheduleAdapter(scheduleItem,requireContext())
        binding.scheduleCellRecyclerview.adapter = adapter

    }


}