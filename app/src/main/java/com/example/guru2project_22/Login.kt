package com.example.guru2project_22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Login : AppCompatActivity() {
    lateinit var editNickname: EditText
    lateinit var completeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editNickname = findViewById(R.id.editNickname)
        completeButton = findViewById(R.id.completeButton)

        completeButton.setOnClickListener {

            var sharedPreference = getSharedPreferences("user", 0)
            var editor = sharedPreference.edit()

            editor.putString("nickname", editNickname.text.toString())
            editor.commit()

            //화면전환(메인 액티비티로)
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}