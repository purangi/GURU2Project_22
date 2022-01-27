package com.example.guru2project_22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private val DayActivity = DayActivity()
    private val MainActivity = MainActivity()
    private val CatRoom = CatRoom()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}