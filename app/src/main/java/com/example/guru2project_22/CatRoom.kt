package com.example.guru2project_22

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import org.w3c.dom.Text

class CatRoom : AppCompatActivity() {

    lateinit var backbtn : ImageButton
    lateinit var storebtn : ImageButton
    lateinit var mycoin : TextView
    lateinit var origincat : ImageView
    lateinit var catwindow : ImageView
    lateinit var catfood : ImageView
    lateinit var catbookshelf : ImageView
    lateinit var catsmallplant : ImageView
    lateinit var catbigplant : ImageView
    lateinit var catbathroom : ImageView
    lateinit var catbed : ImageView
    lateinit var catcircle : ImageView
    lateinit var cathome : ImageView
    lateinit var catsofa : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_room)

        backbtn = findViewById(R.id.backbtn)
        storebtn = findViewById(R.id.storebtn)
        mycoin = findViewById(R.id.mycoin)
        origincat = findViewById(R.id.originCat)
        catwindow = findViewById(R.id.cat_window)
        catfood = findViewById(R.id.cat_catfood)
        catbookshelf = findViewById(R.id.cat_bookshelf)
        catsmallplant = findViewById(R.id.cat_smallplant)
        catbigplant = findViewById(R.id.cat_bigplant)
        catbathroom = findViewById(R.id.cat_catbathroom)
        catbed = findViewById(R.id.cat_catbed)
        catcircle =findViewById(R.id.cat_circle2)
        cathome =findViewById(R.id.cat_home)
        catsofa =findViewById(R.id.cat_sofa)

        loadCoin()

        var type = intent.getStringExtra("number")
        when(type){
            "1" -> catfood.visibility = View.VISIBLE
        }



        backbtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        storebtn.setOnClickListener {
            var intent = Intent(this, Store::class.java)
            startActivity(intent)
        }


    }

   private fun loadCoin() {
        var pref = this.getPreferences(0)
        var coin = pref.getInt("mycoin",0)
        mycoin.text=coin.toString()
    }
}