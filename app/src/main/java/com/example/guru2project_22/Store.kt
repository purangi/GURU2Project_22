package com.example.guru2project_22

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.sql.SQLClientInfoException


class Store : AppCompatActivity() {

    var price = 0
    var mycoin = 0


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
            onBackPressed()
        }

        val shared = getSharedPreferences("coin", 0)
        val editor = shared.edit()
        mycoin = shared.getInt("mycoin",0)

        buybtn.setOnClickListener {

            when (activeRadioButton.id) {
                R.id.catfood -> price =10
                R.id.smallplant -> price =50
                R.id.bigplant -> price =50
                R.id.catbathroom -> price =80
                R.id.catplaying -> price=100
                R.id.light -> price =150
                R.id.window -> price =200
                R.id.cathome -> price =250
                R.id.cattable -> price=300
                R.id.bookshelf -> price =450
                R.id.catcircle ->price =500
                R.id.cattower -> price =600
                R.id.catsofa -> price =700
                R.id.catbed -> price =800
                R.id.cattv -> price =1000
                else -> Toast.makeText(this, "아이템을 선택해라 냥", Toast.LENGTH_SHORT).show()
            }

            if(mycoin>=price){
                mycoin -= price
                //shared 수정, 저장
                editor.putString("coin", mycoin.toString()).apply()
                Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
            } else Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
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

    fun clickRB(view: View) {
        var radioButton = view as RadioButton

        if(activeRadioButton != null) {
            activeRadioButton.isChecked = false
        }
        radioButton.isChecked = true
        activeRadioButton = radioButton
    }

    //store, catroom에서 쓸 item DB
    class itemDBHelper(context: Context) : SQLiteOpenHelper(context, "itemDB" , null,1){
        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL("CREATE TABLE itemTBL (itemName CHAR(15) PRIMARY KEY, itemResource String);")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            // 안 씀
        }
    }
}