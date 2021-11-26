package com.wanted.wantedproject.api

import com.wanted.wantedproject.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object SaiRetrofit {
    private val retrofit: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.SAI_DOMAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    }
    val classListApi: ClassApi by lazy {
        retrofit.build().create(ClassApi::class.java)
    }
}