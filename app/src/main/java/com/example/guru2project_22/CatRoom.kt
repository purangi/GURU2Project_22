package com.example.guru2project_22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import org.w3c.dom.Text

class CatRoom : AppCompatActivity() {

    lateinit var backbtn : ImageButton
    lateinit var storebtn : ImageButton
    lateinit var item : ImageButton
    //lateinit var drawer : DrawerLayout
    lateinit var mycoin : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_room)

        backbtn = findViewById(R.id.backbtn)
        storebtn = findViewById(R.id.storebtn)
        item = findViewById(R.id.item)
        //drawer = findViewById(R.id.drawer)
        mycoin = findViewById(R.id.mycoin)

        loadCoin()

        backbtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        storebtn.setOnClickListener {
            var intent = Intent(this, Store::class.java)
            startActivity(intent)
        }

        item.setOnClickListener {
            /*if(!drawer.isDrawerOpen(Gravity.RIGHT)){
                drawer.openDrawer(Gravity.RIGHT)
            }*/

        }

    }

    private fun loadCoin() {
        var pref = this.getPreferences(0)
        var coin = pref.getInt("MYCOIN",0)

        if(coin != 0){
            mycoin.setText(coin.toString())
        }
    }
}