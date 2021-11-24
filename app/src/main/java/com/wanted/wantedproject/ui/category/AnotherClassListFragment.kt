package com.wanted.wantedproject.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.wanted.wantedproject.R
import com.wanted.wantedproject.databinding.FragmentAnotherClassListBinding

class AnotherClassListFragment : Fragment() {
    private lateinit var binding : FragmentAnotherClassListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_another_class_list, container, false)

        setOnClickEvent()

        return binding.root
    }

    private fun setOnClickEvent() {
        binding.toolBar.arrowBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}