package com.example.guru2project_22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.guru2project_22.databinding.ActivityMyPageBinding


class MyPage : AppCompatActivity() {

    private lateinit var binding: ActivityMyPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰 바인딩
        binding = ActivityMyPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var parent: ViewGroup = findViewById(R.id.catLayout)
        //var catView = findViewById<View>(R.id.catView)
        var pref = getSharedPreferences("user", 0)
        var editor = pref.edit()

        //닉네임 설정
        binding.myNickname.text = pref.getString("nickname", "").toString()

        //고양이 창 나타내기
        //catView =
        LayoutInflater.from(this).inflate(R.layout.fragment_cat, parent, true)
        //parent.addView(catView, 500, 500)

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
                binding.myNickname.text = editName.text.toString()
                mAlertDialog.dismiss()
                //SharedPreferences 값 수정
                editor.remove("nickname").apply()
                editor.putString("nickname", binding.myNickname.text.toString()).apply()
            }

        }



    }
}