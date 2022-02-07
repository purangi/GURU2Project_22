package com.example.guru2project_22

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class Store : AppCompatActivity() {

    var price = 0
    var mycoin = 0
    var mybuy ="0"

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

        //뒤로가기 버튼
        backbtn.setOnClickListener {
            onBackPressed()
        }

        val pref = getSharedPreferences("user", 0)
        val editor = pref.edit()
        mycoin = (pref.getString("coin","500"))!!.toInt()

        //구매 버튼 클릭 시
        buybtn.setOnClickListener {
            //coin 받아오기
            mybuy = (pref.getString("buy","0")).toString()
            Log.v("mybuy", mycoin.toString())

            //선택한 버튼의 id 받아서 price 처리
            when (activeRadioButton.id) {
                R.id.catfood -> {
                    if(mybuy=="1"){
                        price =0
                        Toast.makeText(this, "갖고 있다 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        price =10
                        editor.putString("buy", "1")
                    }
                }
                R.id.smallplant -> {
                    if(mybuy=="2"){
                        price =0
                        Toast.makeText(this, "갖고 있다 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        price =50
                        editor.putString("buy", "2")
                    }
                }
                R.id.bigplant -> {
                    if(mybuy=="3"){
                        price =0
                        Toast.makeText(this, "갖고 있다 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        price =50
                        editor.putString("buy", "3")
                    }
                }
                R.id.catbathroom -> {
                    if(mybuy=="4"){
                        price =0
                        Toast.makeText(this, "갖고 있다 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        price =80
                        editor.putString("buy", "4")
                    }
                }
                R.id.catplaying -> {
                    if(mybuy=="5"){
                        price =0
                        Toast.makeText(this, "갖고 있다 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        price =100
                        editor.putString("buy", "5")
                    }
                }
                R.id.light -> {
                    if(mybuy=="6"){
                        price =0
                        Toast.makeText(this, "갖고 있다 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        price =150
                        editor.putString("buy", "6")
                    }
                }
                R.id.window -> {
                    if(mybuy=="7"){
                        price =0
                        Toast.makeText(this, "갖고 있다 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        price =200
                        editor.putString("buy", "7")
                    }
                }
                R.id.cathome -> {
                    if(mybuy=="8"){
                        price =0
                        Toast.makeText(this, "갖고 있다 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        price =250
                        editor.putString("buy", "8")
                    }
                }
                R.id.cattable -> {
                    if(mybuy=="9"){
                        price =0
                        Toast.makeText(this, "갖고 있다 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        price =300
                        editor.putString("buy", "9")
                    }
                }
                R.id.bookshelf -> {
                    if(mybuy=="10"){
                        price =0
                        Toast.makeText(this, "갖고 있다 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        price =450
                        editor.putString("buy", "10")
                    }
                }
                R.id.catcircle -> {
                    if(mybuy=="11"){
                        price =0
                        Toast.makeText(this, "갖고 있다 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        price =500
                        editor.putString("buy", "11")
                    }
                }
                R.id.cattower -> {
                    if(mybuy=="12"){
                        price =0
                        Toast.makeText(this, "갖고 있다 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        price =600
                        editor.putString("buy", "12")
                    }
                }
                R.id.catsofa -> {
                    if(mybuy=="13"){
                        price =0
                        Toast.makeText(this, "갖고 있다 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        price =700
                        editor.putString("buy", "13")
                    }
                }
                R.id.catbed -> {
                    if(mybuy=="14"){
                        price =0
                        Toast.makeText(this, "갖고 있다 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        price =800
                        editor.putString("buy", "14")
                    }
                }
                R.id.cattv -> {
                    if(mybuy=="15"){
                        price =0
                        Toast.makeText(this, "갖고 있다 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        price =1000
                        editor.putString("buy", "15")
                    }
                }

                else -> Toast.makeText(this, "아이템을 선택해라 냥", Toast.LENGTH_SHORT).show()
            }

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

            mybuy = (pref.getString("buy","0")).toString()
            Log.v("mybuy",mybuy)

            //선택한 item의 id 받아서 item 꾸미기 처리
            when (activeRadioButton.id) {
                R.id.catfood -> {
                    if(mybuy=="1") {
                        editor.putString("item1", "1")
                        Toast.makeText(this, "꾸며보자 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "아이템을 구매해라 냥", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.smallplant -> {
                    if(mybuy=="2") {
                        editor.putString("item2", "2")
                        Toast.makeText(this, "꾸며보자 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "아이템을 구매해라 냥", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.bigplant -> {
                    if(mybuy=="3") {
                        editor.putString("item3", "3")
                        Toast.makeText(this, "꾸며보자 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "아이템을 구매해라 냥", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.catbathroom -> {
                    if(mybuy=="4") {
                        editor.putString("item4", "4")
                        Toast.makeText(this, "꾸며보자 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "아이템을 구매해라 냥", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.catplaying -> {
                    if(mybuy=="5") {
                        editor.putString("item5", "5")
                        Toast.makeText(this, "꾸며보자 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "아이템을 구매해라 냥", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.light -> {
                    if(mybuy=="6") {
                        editor.putString("item6", "6")
                        Toast.makeText(this, "꾸며보자 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "아이템을 구매해라 냥", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.window -> {
                    if(mybuy=="7") {
                        editor.putString("item7", "7")
                        Toast.makeText(this, "꾸며보자 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "아이템을 구매해라 냥", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.cathome -> {
                    if(mybuy=="8") {
                        editor.putString("item8", "8")
                        Toast.makeText(this, "꾸며보자 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "아이템을 구매해라 냥", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.cattable -> {
                    if(mybuy=="9") {
                        editor.putString("item9", "9")
                        Toast.makeText(this, "꾸며보자 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "아이템을 구매해라 냥", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.bookshelf -> {
                    if(mybuy=="10") {
                        editor.putString("item10", "10")
                        Toast.makeText(this, "꾸며보자 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "아이템을 구매해라 냥", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.catcircle -> {
                    if(mybuy=="11") {
                        editor.putString("item11", "11")
                        Toast.makeText(this, "꾸며보자 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "아이템을 구매해라 냥", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.cattower -> {
                    if(mybuy=="12") {
                        editor.putString("item12", "12")
                        Toast.makeText(this, "꾸며보자 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "아이템을 구매해라 냥", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.catsofa -> {
                    if(mybuy=="13") {
                        editor.putString("item13", "13")
                        Toast.makeText(this, "꾸며보자 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "아이템을 구매해라 냥", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.catbed -> {
                    if(mybuy=="14") {
                        editor.putString("item14", "14")
                        Toast.makeText(this, "꾸며보자 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "아이템을 구매해라 냥", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.cattv -> {
                    if(mybuy=="15") {
                        editor.putString("item15", "15")
                        Toast.makeText(this, "꾸며보자 냥", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "아이템을 구매해라 냥", Toast.LENGTH_SHORT).show()
                    }
                }
                else -> Toast.makeText(this, "아이템을 선택해라 냥", Toast.LENGTH_SHORT).show()
            }

            editor.apply()

            //CatRoom 으로 전환
            var intent = Intent(this, CatRoom::class.java)
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

}
