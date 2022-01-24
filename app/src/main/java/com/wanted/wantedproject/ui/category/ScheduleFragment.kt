package com.wanted.wantedproject.ui.category

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.wanted.wantedproject.R
import com.wanted.wantedproject.data.MyClass
import com.wanted.wantedproject.databinding.FragmentScheduleBinding
import com.wanted.wantedproject.adapter.TodoAdapter

class ScheduleFragment : Fragment() {
    private lateinit var binding : FragmentScheduleBinding
    private var todoAdapter = TodoAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_schedule, container,false)

        setTodoAdapter()
        setTodoData()
        changeWeek()

        return binding.root
    }

    private fun setTodoAdapter() {
        binding.scheduelTodoRecyclerview.adapter = todoAdapter
    }

    private fun setTodoData() {
        val todoList = arrayListOf<MyClass>()
        todoList.add(MyClass("1001","과제하기", "개인","09:00","12:00", "monday"))
        todoList.add(MyClass("1002","IT·프로그램", "코딩 클래스","12:00","14:00", "monday"))
        todoAdapter.setItems(todoList)
    }

    private fun changeWeek() {
        binding.scheduleGui.diyClass.setOnClickListener {
            binding.thursday.performClick()
            val itemList = arrayListOf<MyClass>()
            itemList.add(MyClass("1003","공예·DIY 클래스", "원하는 목도리를 만들어봐요!","10:00","11:30", "thursday"))
            todoAdapter.setItems(itemList)
            val drawable : GradientDrawable = binding.scheduleGui.diyClass.background as GradientDrawable
            drawable.setStroke(10, Color.parseColor("#2578fb"))
            binding.scheduleGui.diyClass.setImageResource(R.drawable.ic_check)
        }

    }


}