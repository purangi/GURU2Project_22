package com.example.guru2project_22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.guru2project_22.databinding.ActivityMainBinding


class MyPage : AppCompatActivity() {
    lateinit var myNickname: TextView
    lateinit var pencilButton: ImageButton
    lateinit var catView: View
    private lateinit var binding: ActivityMainBinding
    private lateinit var binding2: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        var pref = getSharedPreferences("user", Context.MODE_PRIVATE)

        myNickname = findViewById(R.id.myNickname)
        pencilButton = findViewById(R.id.pencilButton)
        catView = findViewById(R.id.catView)
        myNickname.text = pref.getString("nickname", "").toString()

        //뷰 바인딩
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding2 = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding2.root)

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
                myNickname.text = editNickname.text.toString()
                mAlertDialog.dismiss()
            }
        }

        catView = LayoutInflater.from(this).inflate(R.layout.activity_cat_room, null)


    }
}