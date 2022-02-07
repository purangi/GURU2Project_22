package com.example.guru2project_22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    lateinit var editNickname: EditText
    lateinit var completeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editNickname = findViewById(R.id.editNickname)
        completeButton = findViewById(R.id.completeButton)

        //완료 버튼 누를 시
        completeButton.setOnClickListener {

            var sharedPreference = getSharedPreferences("user", 0)
            var editor = sharedPreference.edit()

            //닉네임 저장
            editor.putString("nickname", editNickname.text.toString())
            editor.apply()

            //입력 안하면 토스트
            if (sharedPreference.getString("nickname", "").isNullOrBlank())
            {
                Toast.makeText(this@Login, "닉네임을 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else //화면전환(메인 액티비티로)
            {
                var intent = Intent(this, MainActivity::class.java)
                finish()
                startActivity(intent)
            }

        }
    }
}