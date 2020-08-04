package com.devddun.apptoapptestapp.`interface`

import com.devddun.apptoapptestapp.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitService {

    @GET("/users")
    fun requestSearchUser(

    ) : Call<List<User>>
}