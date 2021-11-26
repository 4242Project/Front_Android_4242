package com.wanted.wantedproject.ui.schoolclass

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.wanted.wantedproject.R
import com.wanted.wantedproject.databinding.FragmentClassDetailBinding
import com.wanted.wantedproject.databinding.FragmentClassDetailInfoBinding

class ClassDetailInfoFragment : Fragment() {
    private lateinit var binding : FragmentClassDetailInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_class_detail_info, container, false)

        setImageBackground()

        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setImageBackground() {
        binding.imageView2.background = resources.getDrawable(R.drawable.radius_image_background,null)
        binding.imageView15.background = resources.getDrawable(R.drawable.radius_image_background,null)
        binding.imageView16.background = resources.getDrawable(R.drawable.radius_image_background,null)
        binding.imageView17.background = resources.getDrawable(R.drawable.radius_image_background,null)
        binding.imageView18.background = resources.getDrawable(R.drawable.radius_image_background,null)

        binding.imageView2.clipToOutline = true
        binding.imageView15.clipToOutline = true
        binding.imageView16.clipToOutline = true
        binding.imageView17.clipToOutline = true
        binding.imageView18.clipToOutline = true

    }

}