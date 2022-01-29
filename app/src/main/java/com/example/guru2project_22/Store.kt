package com.example.guru2project_22

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class Store : AppCompatActivity() {

    var mycoin=200

    lateinit var backbtn : ImageButton
    lateinit var okbtn : Button

    lateinit var storeGroup : RadioGroup
    lateinit var catfood : RadioButton
    lateinit var smallplant : RadioButton
    lateinit var bigplant : RadioButton
    lateinit var catbathroom : RadioButton
    lateinit var catplaying : RadioButton
    lateinit var light : RadioButton
    lateinit var window : RadioButton
    lateinit var cathome : RadioButton
    lateinit var cattable : RadioButton
    lateinit var bookshelf : RadioButton
    lateinit var catcircle : RadioButton
    lateinit var cattower : RadioButton
    lateinit var catsofa : RadioButton
    lateinit var catbed : RadioButton
    lateinit var cattv : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        backbtn = findViewById(R.id.backbtn)
        okbtn=findViewById(R.id.okbtn)

        storeGroup = findViewById(R.id.storeGroup)
        catfood = findViewById(R.id.catfood)
        smallplant = findViewById(R.id.smallplant)
        bigplant = findViewById(R.id.bigplant)
        catbathroom = findViewById(R.id.catbathroom)
        catplaying = findViewById(R.id.catplaying)
        light = findViewById(R.id.light)
        window = findViewById(R.id.window)
        cathome = findViewById(R.id.cathome)
        cattable = findViewById(R.id.cattable)
        bookshelf = findViewById(R.id.bookshelf)
        catcircle = findViewById(R.id.catcircle)
        cattower = findViewById(R.id.cattower)
        catsofa = findViewById(R.id.catbed)
        catbed= findViewById(R.id.catbed)
        cattv = findViewById(R.id.cattv)



        backbtn.setOnClickListener {
            var intent = Intent(this, CatRoom::class.java)
            startActivity(intent)
        }

        okbtn.setOnClickListener {



            when (storeGroup.getCheckedRadioButtonId()) {
                R.id.catfood -> {
                    mycoin = mycoin - 10
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.smallplant -> {
                    mycoin = mycoin - 50
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.bigplant -> {
                    mycoin = mycoin - 50
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.catbathroom -> {
                    mycoin = mycoin - 80
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.catplaying -> {
                    mycoin = mycoin - 100
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.light -> {
                    mycoin = mycoin - 150
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.window -> {
                    mycoin = mycoin - 200
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.cathome -> {
                    mycoin = mycoin - 250
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.cattable -> {
                    mycoin = mycoin - 300
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.bookshelf -> {
                    mycoin = mycoin - 450
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.catcircle -> {
                    mycoin = mycoin - 500
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.cattower -> {
                    mycoin = mycoin - 600
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.catsofa -> {
                    mycoin = mycoin - 700
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.catbed -> {
                    mycoin = mycoin - 800
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.cattv -> {
                    mycoin = mycoin - 1000
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }



               else -> Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()

            }

            saveCoin(mycoin.toString().toInt())
            var intent = Intent(this, CatRoom::class.java)
            //intent.putExtra("mycoin",mycoin.toString())
            startActivity(intent)

        }
    }

    private fun saveCoin(coin:Int){
        var pref = this.getPreferences(0)
        var editor = pref.edit()

        editor.putInt("MYCOIN", mycoin.toString().toInt()).apply()
    }

}