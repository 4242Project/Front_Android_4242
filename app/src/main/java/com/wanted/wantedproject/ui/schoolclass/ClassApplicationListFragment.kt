package com.wanted.wantedproject.ui.schoolclass

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.wanted.wantedproject.R
import com.wanted.wantedproject.databinding.FragmentClassApplicationListBinding

class ClassApplicationListFragment : Fragment() {
    private lateinit var binding : FragmentClassApplicationListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_class_application_list, container, false)

        setImage()
        setOnClickEvent()

        return binding.root
    }

    private fun setImage() {
        binding.student2.oneStamp.visibility = View.INVISIBLE
        binding.student2.twoStamp.setImageResource(R.drawable.ic_class_baking)
        binding.student2.threeStamp.setImageResource(R.drawable.ic_class_talking)
        binding.student2.profileImg.setImageResource(R.drawable.ic_profile_y)

        binding.student3.oneStamp.setImageResource(R.drawable.ic_class_cooking)
        binding.student3.twoStamp.setImageResource(R.drawable.ic_class_baking)
        binding.student3.threeStamp.setImageResource(R.drawable.ic_class_music)
        binding.student3.profileImg.setImageResource(R.drawable.ic_profile_gr)
    }

    private fun setOnClickEvent(){
        binding.include6.arrowBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}