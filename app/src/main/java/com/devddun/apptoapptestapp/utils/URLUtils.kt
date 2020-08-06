package com.devddun.apptoapptestapp.utils

import com.google.gson.JsonObject
import org.json.JSONObject
import java.net.URLDecoder
import java.net.URLEncoder

object URLUtils {
    var tempJson = JSONObject()
    lateinit var url: String

    fun encode(jsonObject: JSONObject): String {
        try {
            url = URLEncoder.encode(jsonObject.toString(), "UTF-8")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return url
    }

    fun decode(string: String): String {
        try {
            url = URLDecoder.decode(string, "UTF-8")
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return url
    }

    fun makeJson(): JSONObject {
        tempJson.put("id", "1")
        tempJson.put("name", "DDUN")
        tempJson.put("AGE", "31")
        return tempJson
    }
}