package com.wanted.wantedproject.ui.home.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.wanted.wantedproject.R
import com.wanted.wantedproject.api.SaiRetrofit
import com.wanted.wantedproject.data.HobbyClass
import com.wanted.wantedproject.databinding.FragmentClassListBinding
import com.wanted.wantedproject.ui.category.adapter.AnotherClassAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class ClassListFragment : Fragment() {

    private lateinit var binding : FragmentClassListBinding
    private val adapter = AnotherClassAdapter(0)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_class_list, container, false)

        setAdapter()
        getClassList()
        return binding.root
    }

    private fun setAdapter() {
        binding.homeClassRecyclerview.adapter = adapter
    }

    private fun getClassList() {
        //val encodedId = java.net.URLEncoder.encode("베이킹", "utf-8")
        val classCall = SaiRetrofit.classListApi.getClassList("베이킹")
        classCall.enqueue(object : Callback<ArrayList<HobbyClass>> {
            override fun onResponse(call: Call<ArrayList<HobbyClass>>, response: Response<ArrayList<HobbyClass>>) {
                if(response.isSuccessful) {
                    Timber.d("response${response.body()}")
                    val list = response.body()
                    if (list != null) {
                        adapter.setItems(list)
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<HobbyClass>>, t: Throwable) {
                Timber.d("error${t.message}")
            }

        })


    }

    private fun setItem() {
        val array = arrayListOf<HobbyClass>()
        array.add(HobbyClass("1001","1002","베이킹","뚜지",20,16000,"2021-11-27",""))
        adapter.setItems(array)
    }

}