package com.example.guru2project_22

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        var pref = getSharedPreferences("user", 0)
        var editor = pref.edit()

        //네비게이션 이미지 버튼
        binding.navday.setOnClickListener{
            val intent = Intent(this, DayActivity::class.java)
            startActivity(intent)
        }

        binding.navhome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.navmypage.setOnClickListener{
            val intent = Intent(this, MyPage::class.java)
            startActivity(intent)
        }

        //coin 공유
        val shared = getSharedPreferences("coin", Context.MODE_PRIVATE)
        var coin = shared.getInt("mycoin",0)
        binding.mycoin.text=coin.toString()

        //닉네임 설정
        binding.myNickname.text = pref.getString("nickname", "").toString()

        //이름 설정
        binding.name.text = pref.getString("name", "").toString()

        //이메일 설정
        binding.email.text = pref.getString("email", "").toString()

        //생일 설정
        binding.birth.text = pref.getString("birth", "").toString()

        //고양이 창 나타내기
        LayoutInflater.from(this).inflate(R.layout.fragment_cat, parent, true)

        //연필 버튼 누를 시
        binding.pencilButton.setOnClickListener {

            //Dialog 만들기
            var mDialogView = LayoutInflater.from(this).inflate(R.layout.change_nickname, null)
            var mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)

            var mAlertDialog = mBuilder.show()
            mAlertDialog.window!!.setLayout(MATCH_PARENT, WRAP_CONTENT)

            var changeButton = mDialogView.findViewById<Button>(R.id.changeButton)
            var editName = mDialogView.findViewById<EditText>(R.id.editEmail)

            //변경 버튼 누를 시
            changeButton.setOnClickListener {
                binding.myNickname.text = editName.text.toString()
                mAlertDialog.dismiss()
                //SharedPreferences 값 수정
                editor.remove("nickname").apply()
                editor.putString("nickname", binding.myNickname.text.toString()).apply()
            }
        }

        //이름 연필버튼 누를 시
        binding.pencilButton2.setOnClickListener {

            //Dialog 만들기
            var mDialogView = LayoutInflater.from(this).inflate(R.layout.change_name, null)
            var mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)

            var mAlertDialog = mBuilder.show()
            mAlertDialog.window!!.setLayout(MATCH_PARENT, WRAP_CONTENT)

            var nameOKButton = mDialogView.findViewById<Button>(R.id.nameOKButton)
            var editName = mDialogView.findViewById<EditText>(R.id.editEmail)

            //확인 버튼 누를 시
            nameOKButton.setOnClickListener {
                binding.name.text = editName.text.toString()
                mAlertDialog.dismiss()
                //SharedPreferences 값 수정
                editor.remove("name").apply()
                editor.putString("name", binding.name.text.toString()).apply()
            }
        }

        //이메일 연필버튼 누를 시
        binding.pencilButton3.setOnClickListener {

            //Dialog 만들기
            var mDialogView = LayoutInflater.from(this).inflate(R.layout.change_email, null)
            var mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)

            var mAlertDialog = mBuilder.show()
            mAlertDialog.window!!.setLayout(MATCH_PARENT, WRAP_CONTENT)

            var emailOKButton = mDialogView.findViewById<Button>(R.id.emailOKButton)
            var editEmail = mDialogView.findViewById<EditText>(R.id.editEmail)

            //확인 버튼 누를 시
            emailOKButton.setOnClickListener {
                binding.email.text = editEmail.text.toString()
                mAlertDialog.dismiss()
                //SharedPreferences 값 수정
                editor.remove("email").apply()
                editor.putString("email", binding.email.text.toString()).apply()
            }
        }

        //생일 연필버튼 누를 시
        binding.pencilButton4.setOnClickListener {

            //Dialog 만들기
            var mDialogView = LayoutInflater.from(this).inflate(R.layout.change_birth, null)
            var mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)

            var mAlertDialog = mBuilder.show()
            mAlertDialog.window!!.setLayout(MATCH_PARENT, WRAP_CONTENT)

            var birthOKButton = mDialogView.findViewById<Button>(R.id.birthOKButton)
            var editBirth = mDialogView.findViewById<EditText>(R.id.editBirth)

            //확인 버튼 누를 시
            birthOKButton.setOnClickListener {
                binding.birth.text = editBirth.text.toString()
                mAlertDialog.dismiss()
                //SharedPreferences 값 수정
                editor.remove("birth").apply()
                editor.putString("birth", binding.birth.text.toString()).apply()
            }
        }
    }
}