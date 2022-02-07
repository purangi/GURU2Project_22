package com.example.guru2project_22

import android.content.Context
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import org.w3c.dom.Text

class CatRoom : AppCompatActivity() {

    lateinit var backbtn : ImageButton
    lateinit var storebtn : ImageButton
    lateinit var mycoin : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_room)

        backbtn = findViewById(R.id.backbtn)
        storebtn = findViewById(R.id.storebtn)
        mycoin = findViewById(R.id.mycoin)

        //coin 받아오기
        loadCoin()

        //뒤로가기 버튼 클릭 시
        backbtn.setOnClickListener {
            onBackPressed()
        }

        //store 버튼 클릭 시
        storebtn.setOnClickListener {
            var intent = Intent(this, Store::class.java)
            startActivity(intent)
        }


    }

    //coin 받아오기
   private fun loadCoin() {
        val pref = getSharedPreferences("user", 0)
        mycoin.text = pref.getString("coin","500").toString()
    }
}