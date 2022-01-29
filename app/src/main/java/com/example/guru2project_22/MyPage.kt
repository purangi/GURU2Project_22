package com.example.guru2project_22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MyPage : AppCompatActivity() {

    lateinit var mycoin : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        mycoin = findViewById(R.id.mycoin)

        loadCoin()

    }

    private fun loadCoin() {
        var pref = this.getPreferences(0)
        var coin = pref.getInt("MYCOIN",0)

        if(coin != 0){
            mycoin.setText(coin.toString())
        }
    }
}