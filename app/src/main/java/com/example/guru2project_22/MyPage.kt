package com.example.guru2project_22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.guru2project_22.databinding.ActivityMainBinding


class MyPage : AppCompatActivity() {
    lateinit var myNickname: TextView
    lateinit var pencilButton: Button
    private lateinit var binding: ActivityMainBinding
    var sharedPreference = getSharedPreferences("user", 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        myNickname = findViewById(R.id.myNickname)
        pencilButton = findViewById(R.id.pencilButton)
        myNickname.setText(sharedPreference.getString("nickname", ""))

        //뷰 바인딩
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //연필 버튼 누를 시
        pencilButton.setOnClickListener {
            //Dialog 만들기
            var mDialogView = LayoutInflater.from(this).inflate(R.layout.change_nickname, null)
            var mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)

            var mAlertDialog = mBuilder.show()

            var changeButton = mDialogView.findViewById<Button>(R.id.changeButton)
            var editNickname = mDialogView.findViewById<EditText>(R.id.editNickname)

            //변경 버튼 누를 시
            changeButton.setOnClickListener {
                myNickname.setText(editNickname.text.toString())
                mAlertDialog.dismiss()
            }
        }



    }
}