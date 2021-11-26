package com.wanted.wantedproject.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.wanted.wantedproject.R
import com.wanted.wantedproject.SaiApplication
import com.wanted.wantedproject.databinding.FragmentLoginBinding
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login, container, false)

        lifecycleScope.launch {
            SaiApplication.getInstance().getDataStore().setToolbarVisibility(false)
        }

        editTextEvent()
        setOnClickListener()

        return binding.root
    }

    private fun editTextEvent() {
        binding.editEmailBox.addTextChangedListener {

        }
        binding.editPassword.addTextChangedListener {

        }
    }

    private fun setOnClickListener() {
        binding.loginBtn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_selectStampFragment)
        }

        binding.registerBtn.setOnClickListener {

        }
    }


}