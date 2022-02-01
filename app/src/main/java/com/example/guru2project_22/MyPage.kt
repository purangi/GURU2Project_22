package com.example.guru2project_22

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.guru2project_22.databinding.ActivityMyPageBinding


class MyPage : AppCompatActivity() {
    lateinit var myNickname: TextView
    lateinit var pencilButton: ImageButton
    lateinit var catView: View
    private lateinit var binding: ActivityMyPageBinding
    //private lateinit var binding2: ActivityMyPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_my_page)

        //뷰 바인딩
        binding = ActivityMyPageBinding.inflate(layoutInflater) //팝업창 부분
        setContentView(binding.root)
        //binding2 = ActivityMyPageBinding.inflate(layoutInflater) //고양이 부분
        //setContentView(binding2.root)

        var pref = getSharedPreferences("user", 0)
        var editor = pref.edit()

        myNickname = findViewById(R.id.myNickname)
        pencilButton = findViewById(R.id.pencilButton)
        catView = findViewById(R.id.catView)
        myNickname.text = pref.getString("nickname", "").toString()

        //연필 버튼 누를 시
        binding.pencilButton.setOnClickListener {
            //Dialog 만들기
            var mDialogView = LayoutInflater.from(this).inflate(R.layout.change_nickname, null)
            var mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)

            var mAlertDialog = mBuilder.show()
            mAlertDialog.window!!.setLayout(MATCH_PARENT, WRAP_CONTENT)

            var changeButton = mDialogView.findViewById<Button>(R.id.changeButton)
            var editName = mDialogView.findViewById<EditText>(R.id.editName)

            //변경 버튼 누를 시
            changeButton.setOnClickListener {
                myNickname.text = editName.text.toString()
                mAlertDialog.dismiss()
                //SharedPreferences 값 수정
                editor.remove("nickname").apply()
                editor.putString("nickname", myNickname.text.toString()).apply()
            }
        }

        //고양이 나타내기
        //catView = LayoutInflater.from(this).inflate(R.layout.activity_cat_room, null)


    }
}