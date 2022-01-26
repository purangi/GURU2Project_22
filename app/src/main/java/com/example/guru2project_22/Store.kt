package com.example.guru2project_22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast

class Store : AppCompatActivity() {

    lateinit var backbtn : ImageButton
    lateinit var okbtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        backbtn = findViewById(R.id.backbtn)
        okbtn=findViewById(R.id.okbtn)



        backbtn.setOnClickListener {
            var intent = Intent(this, CatRoom::class.java)
            startActivity(intent)
        }

        okbtn.setOnClickListener {
            var intent = Intent(this, CatRoom::class.java)
            startActivity(intent)

            val mycoin=200
            val price =100

            if(mycoin>=price){
                Toast.makeText(this, "구매했다 냥",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "코인이 부족하다 냥",Toast.LENGTH_SHORT).show()
            }

        }
    }
}