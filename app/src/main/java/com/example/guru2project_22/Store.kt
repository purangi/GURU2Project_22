package com.example.guru2project_22

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class Store : AppCompatActivity() {

    var mycoin = 300

    lateinit var backbtn : ImageButton
    lateinit var okbtn : Button

    lateinit var catfood : ImageButton
    lateinit var smallplant : ImageButton
    lateinit var bigplant : ImageButton
    lateinit var catbathroom : ImageButton
    lateinit var catplaying : ImageButton
    lateinit var light : ImageButton
    lateinit var window : ImageButton
    lateinit var cathome : ImageButton
    lateinit var cattable : ImageButton
    lateinit var bookshelf : ImageButton
    lateinit var catcircle : ImageButton
    lateinit var cattower : ImageButton
    lateinit var catsofa : ImageButton
    lateinit var catbed : ImageButton
    lateinit var cattv : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        backbtn = findViewById(R.id.backbtn)
        okbtn=findViewById(R.id.okbtn)

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
        catsofa = findViewById(R.id.catsofa)
        catbed= findViewById(R.id.catbed)
        cattv = findViewById(R.id.cattv)



        backbtn.setOnClickListener {
            var intent = Intent(this, CatRoom::class.java)
            startActivity(intent)
        }




        okbtn.setOnClickListener {

            var intent = Intent(this, CatRoom::class.java)

           /* when () {
                R.id.catfood -> {
                    if(mycoin>=10){
                        mycoin -= 10
                        Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()

                        saveCoin(mycoin.toString().toInt())
                        intent.putExtra("mycoin",mycoin.toString())
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.smallplant -> {
                    mycoin -= 50
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.bigplant -> {
                    mycoin -= 50
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.catbathroom -> {
                    mycoin -= 80
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.catplaying -> {
                    mycoin -= 100
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.light -> {
                    mycoin -= 150
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.window -> {
                    mycoin -= 200
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.cathome -> {
                    mycoin -= 250
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.cattable -> {
                    mycoin -= 300
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.bookshelf -> {
                    mycoin -= 450
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.catcircle -> {
                    mycoin -= 500
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.cattower -> {
                    mycoin -= 600
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.catsofa -> {
                    mycoin -= 700
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.catbed -> {
                    mycoin -= 800
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.cattv -> {
                    mycoin -= 1000
                    Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                }



                else -> Toast.makeText(this, "아이템을 선택해라 냥", Toast.LENGTH_SHORT).show()

            }*/
        }
    }

    private fun saveCoin(coin:Int){
        var pref = this.getPreferences(0)
        var editor = pref.edit()

        editor.putInt("MYCOIN", mycoin.toString().toInt()).apply()
    }

}