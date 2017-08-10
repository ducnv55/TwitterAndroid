package com.example.nguyenvietduc.twitter

import android.util.Log
import com.github.kittinunf.fuel.Fuel

/**
 * Created by nguyenvietduc on 8/3/17.
 */
class TwitterCustom {
    val baseUrl: String = "https://api.twitter.com/1.1/"

    fun fullpath(endpoint: String): String {
        val fullPath = this.baseUrl + endpoint
        return fullPath
    }
}