package com.wanted.wantedproject.api

import com.wanted.wantedproject.data.HobbyClass
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ClassApi {
    @GET("class/list/U001/{name}")
    fun getClassList(@Path("name") id: String): Call<ArrayList<HobbyClass>>

}