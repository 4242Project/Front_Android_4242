package com.wanted.wantedproject.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.wanted.wantedproject.R
import com.wanted.wantedproject.data.Register
import com.wanted.wantedproject.databinding.FragmentFirstRegisterBinding

class FirstRegisterFragment : Fragment() {
    private lateinit var binding: FragmentFirstRegisterBinding

    companion object {
        lateinit var RegisterInfo : Register
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_first_register, container, false)


        return binding.root
    }

}