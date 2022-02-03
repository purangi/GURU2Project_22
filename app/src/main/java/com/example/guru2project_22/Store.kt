package com.example.guru2project_22

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class Store : AppCompatActivity() {

    private var mycoin = 300

    lateinit var backbtn : ImageButton
    lateinit var buybtn : Button
    lateinit var okbtn : Button

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

    lateinit var activeRadioButton : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        backbtn = findViewById(R.id.backbtn)
        buybtn=findViewById(R.id.buybtn)
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

        activeRadioButton = findViewById(R.id.activeRadioButton)

        activeRadioButton.isChecked = true



        backbtn.setOnClickListener {
            var intent = Intent(this, CatRoom::class.java)
            startActivity(intent)
        }


        buybtn.setOnClickListener {

            when (activeRadioButton.id) {
                R.id.catfood -> {
                    if(mycoin>=10){
                        mycoin -= 10
                        Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                    } else Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.smallplant -> {
                    if(mycoin>=50){
                        mycoin -= 50
                        Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                    } else Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.bigplant -> {
                    if(mycoin>=50){
                        mycoin -= 50
                        Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                    } else Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.catbathroom -> {
                    if(mycoin>=80){
                        mycoin -= 80
                        Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                    } else Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.catplaying -> {
                    if(mycoin>=100){
                        mycoin -= 100
                        Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                    } else Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.light -> {
                    if(mycoin>=150){
                        mycoin -= 150
                        Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                    } else Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.window -> {
                    if(mycoin>=200){
                        mycoin -= 200
                        Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                    } else Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.cathome -> {
                    if(mycoin>=250){
                        mycoin -= 250
                        Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                    } else Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.cattable -> {
                    if(mycoin>=300){
                        mycoin -= 300
                        Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                    } else Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.bookshelf -> {
                    if(mycoin>=450){
                        mycoin -= 450
                        Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                    } else Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.catcircle -> {
                    if(mycoin>=500){
                        mycoin -= 500
                        Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                    } else Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.cattower -> {
                    if(mycoin>=600){
                        mycoin -= 600
                        Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                    } else Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.catsofa -> {
                    if(mycoin>=700){
                        mycoin -= 700
                        Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                    } else Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.catbed -> {
                    if(mycoin>=800){
                        mycoin -= 800
                        Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                    } else Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
                }
                R.id.cattv -> {
                    if(mycoin>=1000){
                        mycoin -= 1000
                        Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
                    } else Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
                }

                else -> Toast.makeText(this, "아이템을 선택해라 냥", Toast.LENGTH_SHORT).show()

            }
            saveCoin(mycoin.toString().toInt())
        }

        okbtn.setOnClickListener {
            var intent = Intent(this, CatRoom::class.java)

            when (activeRadioButton.id) {
                R.id.catfood -> intent.putExtra("number","1")
                R.id.smallplant ->intent.putExtra("number","2")
                R.id.bigplant ->intent.putExtra("number","3")
                R.id.catbathroom ->intent.putExtra("number","4")
                R.id.catplaying ->intent.putExtra("number","5")
                R.id.light ->intent.putExtra("number","6")
                R.id.window ->intent.putExtra("number","7")
                R.id.cathome ->intent.putExtra("number","8")
                R.id.cattable ->intent.putExtra("number","9")
                R.id.bookshelf ->intent.putExtra("number","10")
                R.id.catcircle ->intent.putExtra("number","11")
                R.id.cattower ->intent.putExtra("number","12")
                R.id.catsofa ->intent.putExtra("number","13")
                R.id.catbed ->intent.putExtra("number","14")
                R.id.cattv ->intent.putExtra("number","15")

                else -> Toast.makeText(this, "아이템을 선택해라 냥", Toast.LENGTH_SHORT).show()
            }

            startActivity(intent)
        }


    }

   private fun saveCoin(coin:Int){
        var pref = this.getPreferences(0)
        var editor = pref.edit()

        editor.putInt("mycoin", mycoin.toString().toInt()).apply()
   }


    fun clickRB(view: View) {
        var radioButton = view as RadioButton

        if(activeRadioButton != null) {
            activeRadioButton.isChecked = false
        }
        radioButton.isChecked = true
        activeRadioButton = radioButton
    }
}