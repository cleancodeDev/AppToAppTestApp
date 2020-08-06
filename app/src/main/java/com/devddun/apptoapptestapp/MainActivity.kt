package com.devddun.apptoapptestapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import com.devddun.apptoapptestapp.model.User
import com.devddun.apptoapptestapp.service.RetrofitManager
import com.devddun.apptoapptestapp.utils.URLUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"
    private val schemeUrl = "parent_app://parent_action?user_info="


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = intent
        if (intent.action.equals(Intent.ACTION_VIEW)) {
            val uri = intent.data
            val temp = uri?.getQueryParameter("userinfo")
            if (temp != null) {
                runOnUiThread {
                    txt_response.text = temp
                    requestGetUser()
                }
            }
        }

        btn_get.setOnClickListener {
            runOnUiThread {
                requestGetUser()
            }
        }
    }

    private fun requestGetUser() {
        RetrofitManager.getUser().requestSearchUser().enqueue(
                object : Callback<List<User>> {
                    override fun onFailure(call: Call<List<User>>, t: Throwable) {
                        Log.d(TAG, "RESTful Fail : $t")
                    }

                    override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                        Log.d(TAG, "RESTful Success")
                        Log.d(TAG, "Response : ${response.body()}")
                        txt_response.text = response.body().toString()
                        val tempJson: JSONObject = JSONObject()
                        tempJson.put("user_info", response.body().toString())
                        val url = "$schemeUrl${URLUtils.encode(tempJson)}"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        intent.putExtra("user_info", Base64.encodeToString(tempJson.toString().toByteArray(), Base64.NO_WRAP))
                        Log.d(TAG, Base64.encodeToString(tempJson.toString().toByteArray(), Base64.NO_WRAP))
                        setResult(100, intent)
                        finish()
                    }
                }
        )
    }
}