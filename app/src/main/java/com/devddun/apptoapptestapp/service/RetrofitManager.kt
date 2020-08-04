package com.devddun.apptoapptestapp.service

import com.devddun.apptoapptestapp.`interface`.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitManager {
    private const val baseUrl = "https://jsonplaceholder.typicode.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getUser() : RetrofitService = retrofit.create(RetrofitService::class.java)
}