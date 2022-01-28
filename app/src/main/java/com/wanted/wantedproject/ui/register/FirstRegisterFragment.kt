package com.wanted.wantedproject.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.wanted.wantedproject.R
import com.wanted.wantedproject.data.Register
import com.wanted.wantedproject.databinding.FragmentFirstRegisterBinding
import com.wanted.wantedproject.viewmodels.RegisterViewModel

class FirstRegisterFragment : Fragment() {
    private lateinit var binding: FragmentFirstRegisterBinding
    private val registerViewModel : RegisterViewModel by viewModels()
    private var userId = ""
    private var password = ""

    companion object {
        lateinit var RegisterInfo : Register
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_first_register, container, false)

        setEditText()
        sendEmailToConfirm()
        nextStepBtnListener()

        return binding.root
    }

    private fun setEditText() {
        binding.emailInputBox.addTextChangedListener { email ->
            if(binding.emailInputBox.toString().isNotEmpty()) {
                userId = email.toString()
            }
        }
        binding.passwordInputBox.addTextChangedListener { pass ->
            password = pass.toString()
        }
    }

    private fun sendEmailToConfirm() {
        binding.sendEmailBtn.setOnClickListener {
            if(userId.isEmpty())
                Toast.makeText(context, "이메일을 입력해주세요.", Toast.LENGTH_LONG).show()
            else {
                //send to email
                Toast.makeText(context, "입력하신 메일을 확인하여 인증번호를 입력해주세요.", Toast.LENGTH_LONG).show()
            }
        }

        binding.confirmEmailBtn.setOnClickListener {
            //인증번호 같은지 확인
        }
    }

    private fun makeRandomNum()  {

    }

    private fun nextStepBtnListener() {
        binding.nextStepBtn.setOnClickListener {
            //전부입력되었는지 확인, registerInfo에 값 넣기
        }
    }



}