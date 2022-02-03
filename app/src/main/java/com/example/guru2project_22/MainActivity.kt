package com.example.guru2project_22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val MyPage = MyPage()
    private val DayActivity = DayActivity()
    private val MainActivity = MainActivity()
    lateinit var catbutton : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        catbutton.setOnClickListener{
            val intent=Intent(this, CatRoom::class.java)
            startActivity(intent)
        }
    }
}