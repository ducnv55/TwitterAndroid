package com.example.nguyenvietduc.twitter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.twitter.sdk.android.core.identity.TwitterLoginButton
import kotlinx.android.synthetic.main.activity_main.*
import com.example.nguyenvietduc.twitter.R.id.loginButton
import com.twitter.sdk.android.core.*


class MainActivity : AppCompatActivity() {

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Twitter.initialize(this)

        // if authenticated, go to home screen
        if (TwitterCore.getInstance().sessionManager.activeSession != null) {
            goHomeActivity()
        }

        setContentView(R.layout.activity_main)

        twitterLoginButton.callback = object : Callback<TwitterSession>() {
            override fun success(result: Result<TwitterSession>) {
                // Do something with result, which provides a TwitterSession for making API calls
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
            }

            override fun failure(exception: TwitterException) {
                // Do something on failure
                Log.d("Login failed", exception.localizedMessage)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        twitterLoginButton.onActivityResult(requestCode, resultCode, data)
    }

    fun goHomeActivity() {
        val homeIntent = Intent(this@MainActivity, HomeActivity::class.java)
        startActivity(homeIntent)
    }
}
