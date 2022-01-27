package com.example.guru2project_22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class CatRoom : AppCompatActivity() {

    lateinit var backbtn : ImageButton
    lateinit var storebtn : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_room)

        backbtn = findViewById(R.id.backbtn)
        storebtn = findViewById(R.id.storebtn)


        backbtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        storebtn.setOnClickListener {
            var intent = Intent(this, Store::class.java)
            startActivity(intent)
        }

    }
}