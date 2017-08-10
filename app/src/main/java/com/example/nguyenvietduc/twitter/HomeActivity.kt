package com.example.nguyenvietduc.twitter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import com.github.kittinunf.fuel.Fuel
import com.twitter.sdk.android.core.*

class HomeActivity : AppCompatActivity() {

    var userId: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (TwitterCore.getInstance().sessionManager.activeSession == null) {
            goMainActivity()
        } else {
            val twitterCustom = TwitterCustom()
            val fullPath = twitterCustom.fullpath("statuses/user_timeline.json")
            Fuel.get(fullPath).response { request, response, result ->
                result.fold({ d ->
                    Log.d("success", d.toString())
                }, { err ->
                    Log.d("Failed", err.localizedMessage)
                })
            }

        }

//        Log.d("userId", this.userId.toString())
        setContentView(R.layout.activity_home)

    }

    fun goMainActivity() {
        val homeIntent = Intent(this@HomeActivity, MainActivity::class.java)
        startActivity(homeIntent)
    }
}