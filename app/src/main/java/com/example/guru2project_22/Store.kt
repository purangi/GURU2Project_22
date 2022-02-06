package com.example.guru2project_22

import android.content.Context
import android.content.Intent
import android.database.Cursor
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

    lateinit var itemManager : itemDBManager
    lateinit var sqlDB : SQLiteDatabase


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

        itemManager = itemDBManager(this)

        //뒤로가기 버튼
        backbtn.setOnClickListener {
            onBackPressed()
        }

        //구매 버튼 클릭 시
        buybtn.setOnClickListener {
            //coin 받아오기
            val pref = getSharedPreferences("user", 0)
            val editor = pref.edit()
            mycoin = (pref.getString("coin","0"))!!.toInt()

            sqlDB = itemManager.writableDatabase


            //선택한 버튼의 id 받아서 price 처리
            when (activeRadioButton.id) {
                R.id.catfood -> {
                    price =10
                    sqlDB.execSQL("INSERT INTO itemTBL VALUES ('"+ "food"+"',"+1+","+0+");")
                }
                R.id.smallplant -> {
                    price =50
                    sqlDB.execSQL("INSERT INTO itemTBL VALUES ('"+ "small"+"',"+1+","+0+");")
                }
                R.id.bigplant -> {
                    price =50
                    sqlDB.execSQL("INSERT INTO itemTBL VALUES ('"+ "big" +"',"+1+","+0+");")
                }
                R.id.catbathroom -> {
                    price =80
                    sqlDB.execSQL("INSERT INTO itemTBL VALUES ('"+ "bathroom"+"',"+1+","+0+");")
                }
                R.id.catplaying -> {
                    price=100
                    sqlDB.execSQL("INSERT INTO itemTBL VALUES ('"+ "playing"+"',"+1+","+0+");")
                }
                R.id.light -> {
                    price =150
                    sqlDB.execSQL("INSERT INTO itemTBL VALUES ('"+ "light"+"',"+1+","+0+");")
                }
                R.id.window -> {
                    price =200
                    sqlDB.execSQL("INSERT INTO itemTBL VALUES ('"+ "window"+"',"+1+","+0+");")
                }
                R.id.cathome -> {
                    price =250
                    sqlDB.execSQL("INSERT INTO itemTBL VALUES ('"+ "home"+"',"+1+","+0+");")
                }
                R.id.cattable -> {
                    price=300
                    sqlDB.execSQL("INSERT INTO itemTBL VALUES ('"+ "table"+"',"+1+","+0+");")
                }
                R.id.bookshelf -> {
                    price =450
                    sqlDB.execSQL("INSERT INTO itemTBL VALUES ('"+ "bookshelf"+"',"+1+","+0+");")
                }
                R.id.catcircle ->{
                    price =500
                    sqlDB.execSQL("INSERT INTO itemTBL VALUES ('"+ "circle"+"',"+1+","+0+");")
                }
                R.id.cattower -> {
                    price =600
                    sqlDB.execSQL("INSERT INTO itemTBL VALUES ('"+ "tower"+"',"+1+","+0+");")
                }
                R.id.catsofa -> {
                    price =700
                    sqlDB.execSQL("INSERT INTO itemTBL VALUES ('"+ "sofa"+"',"+1+","+0+");")
                }
                R.id.catbed -> {
                    price =800
                    sqlDB.execSQL("INSERT INTO itemTBL VALUES ('"+"bed"+"',"+1+","+0+");")
                }
                R.id.cattv -> {
                    price =1000
                    sqlDB.execSQL("INSERT INTO itemTBL VALUES ('"+ "tv"+"', "+1+","+0+");")
                }
                else -> Toast.makeText(this, "아이템을 선택해라 냥", Toast.LENGTH_SHORT).show()
            }

            sqlDB.close()

            //아이템 구매 처리
            if(mycoin>=price){
                mycoin -= price
                //coin 수정, 저장
                editor.putString("coin", mycoin.toString())
                editor.apply()
                Toast.makeText(this, "구매했다 냥", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "코인이 부족하다 냥", Toast.LENGTH_SHORT).show()
            }
        }

        // 꾸미기 버튼 클릭 시
        okbtn.setOnClickListener {
            var fragment = CatFragment()
            var bundle = Bundle()

            sqlDB = itemManager.readableDatabase

            var cursor : Cursor = sqlDB.rawQuery("SELECT * FROM itemTBL",null )

            while (cursor.moveToNext()){
                var status = cursor.getInt(cursor.getColumnIndex("itemStatus"))
            }

            when (activeRadioButton.id) {
                R.id.catfood -> {
                    bundle.putInt("number",1)
                }
                R.id.smallplant ->{
                    bundle.putInt("number",2)
                }
                R.id.bigplant ->{
                    bundle.putInt("number",3)
                }
                R.id.catbathroom ->{
                    bundle.putInt("number",4)
                }
                R.id.catplaying ->{
                    bundle.putInt("number",5)
                }
                R.id.light ->{
                    bundle.putInt("number",6)
                }
                R.id.window ->{
                    bundle.putInt("number",7)
                }
                R.id.cathome ->{
                    bundle.putInt("number",8)
                }
                R.id.cattable ->{
                    bundle.putInt("number",9)
                }
                R.id.bookshelf ->{
                    bundle.putInt("number",10)
                }
                R.id.catcircle ->{
                    bundle.putInt("number",11)
                }
                R.id.cattower ->{
                    bundle.putInt("number",12)
                }
                R.id.catsofa ->{
                    bundle.putInt("number",13)
                }
                R.id.catbed ->{
                    bundle.putInt("number",14)
                }
                R.id.cattv ->{
                    bundle.putInt("number",15)
                }

                else -> Toast.makeText(this, "아이템을 선택해라 냥", Toast.LENGTH_SHORT).show()
            }
            fragment.arguments = bundle

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
    class itemDBManager(context: Context) : SQLiteOpenHelper(context, "itemDB" , null,1){
        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL("CREATE TABLE itemTBL (itemName CHAR(15) PRIMARY KEY, itemStatus Integer, itemCheck Integer);")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            // 안 씀
        }
    }
}
