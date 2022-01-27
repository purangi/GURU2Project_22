package com.example.guru2project_22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Loading : AppCompatActivity() {
    val DURATION:Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        var sharedPreference = getSharedPreferences("user", 0)

        Handler().postDelayed({
            if (!(sharedPreference.getString("nickname", "").isNullOrBlank()))
            {
                val intent2 = Intent(this, MainActivity::class.java)
                startActivity(intent2)
                finish()
            }
            else
            {
                val intent = Intent(this, Login::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
                finish()
            }

        }, DURATION)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}