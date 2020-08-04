package com.devddun.apptoapptestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.devddun.apptoapptestapp.model.User
import com.devddun.apptoapptestapp.service.RetrofitManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private  val TAG : String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_get.setOnClickListener {
            runOnUiThread {
                requestGetUser()
            }
        }
    }

    private fun requestGetUser(){
        RetrofitManager.getUser().requestSearchUser().enqueue(
            object : Callback<List<User>> {
                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    Log.d(TAG, "RESTful Fail : $t")
                }

                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    Log.d(TAG, "RESTful Success")
                    Log.d(TAG, "Response : ${response.body()}")
                    txt_response.text = response.body().toString()
                }
            }
        )
    }
}