package com.example.guru2project_22

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Loading : AppCompatActivity() {
    val DURATION:Long = 2000 //로딩 페이지 나오는 시간 2초

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        var sharedPreference = getSharedPreferences("user", 0)

        Handler().postDelayed({
            //닉네임 값이 있으면 메인페이지로 이동
            if (!(sharedPreference.getString("nickname", "").isNullOrBlank()))
            {
                val intent2 = Intent(this, MyPage::class.java)
                startActivity(intent2)
                finish()
            }
            //닉네임 값이 없으면 로그인 페이지로 이동
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