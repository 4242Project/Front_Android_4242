package com.wanted.wantedproject.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.wanted.wantedproject.R
import com.wanted.wantedproject.api.SaiRetrofit
import com.wanted.wantedproject.data.HobbyClass
import com.wanted.wantedproject.databinding.FragmentAnotherClassListBinding
import com.wanted.wantedproject.ui.category.adapter.AnotherClassAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class AnotherClassListFragment : Fragment() {
    private lateinit var binding: FragmentAnotherClassListBinding
    private val adapter = AnotherClassAdapter(1)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_another_class_list,
            container,
            false
        )

        setOnClickEvent()
        setAdapter()
        getClassList()


        return binding.root
    }

    private fun setOnClickEvent() {
        binding.toolBar.arrowBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }
    private fun setAdapter() {
        binding.classListRecyclerview.adapter = adapter
    }

    private fun getClassList() {
        //val encodedId = java.net.URLEncoder.encode("베이킹", "utf-8")
        val classCall = SaiRetrofit.classListApi.getClassList("베이킹")
        classCall.enqueue(object : Callback<ArrayList<HobbyClass>> {
            override fun onResponse(call: Call<ArrayList<HobbyClass>> , response: Response<ArrayList<HobbyClass>> ) {
                if(response.isSuccessful) {
                    Timber.d("response${response.body()}")
                    val list = response.body()
                    if (list != null) {
                        adapter.setItems(list)
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<HobbyClass>> , t: Throwable) {
               Timber.d("error${t.message}")
            }

        })


    }
}