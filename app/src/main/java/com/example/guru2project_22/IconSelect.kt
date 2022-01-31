package com.example.guru2project_22

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import java.io.ByteArrayOutputStream


class IconSelect : AppCompatActivity() {
    lateinit var btnBack : ImageButton
    lateinit var btnComplete : Button

    lateinit var rbWater : RadioButton
    lateinit var rbBed : RadioButton
    lateinit var rbComputer : RadioButton
    lateinit var rbExercise : RadioButton
    lateinit var rbExercise2 : RadioButton
    lateinit var rbStudy : RadioButton
    lateinit var rbReading : RadioButton
    lateinit var rbPill : RadioButton
    lateinit var rbMeal : RadioButton
    lateinit var rbShopping : RadioButton
    lateinit var rbBath : RadioButton
    lateinit var rbCleanup : RadioButton

    lateinit var activeRadioButton : RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icon_select)

        btnComplete = findViewById(R.id.btnComplete)
        rbWater = findViewById(R.id.rbWater)
        rbBed = findViewById(R.id.rbBed)
        rbComputer = findViewById(R.id.rbComputer)
        rbExercise = findViewById(R.id.rbExercise)
        rbExercise2 = findViewById(R.id.rbExercise2)
        rbStudy = findViewById(R.id.rbStudy)
        rbReading = findViewById(R.id.rbReading)
        rbPill = findViewById(R.id.rbPill)
        rbMeal = findViewById(R.id.rbMeal)
        rbShopping = findViewById(R.id.rbShopping)
        rbBath = findViewById(R.id.rbBath)
        rbCleanup = findViewById(R.id.rbCleanup)
        btnBack = findViewById(R.id.btnBack)
        activeRadioButton = findViewById(R.id.activeRadioButton)

        activeRadioButton.isChecked = true

        btnBack.setOnClickListener {
            onBackPressed()
        }

        btnComplete.setOnClickListener {
            val iconIntent = Intent(this, HabitActivity::class.java)

            //이미지 방식은 비트맵 전달밖에 안되어서 태그 전달
            when(activeRadioButton.id) {
                R.id.rbWater -> iconIntent.putExtra("icon", "water")
                R.id.rbBed -> iconIntent.putExtra("icon", "bed")
                R.id.rbComputer -> iconIntent.putExtra("icon", "computer")
                R.id.rbExercise -> iconIntent.putExtra("icon", "exercise")
                R.id.rbExercise2 -> iconIntent.putExtra("icon", "exercise2")
                R.id.rbStudy -> iconIntent.putExtra("icon", "study")
                R.id.rbReading -> iconIntent.putExtra("icon", "reading")
                R.id.rbPill -> iconIntent.putExtra("icon", "pill")
                R.id.rbMeal -> iconIntent.putExtra("icon", "meal")
                R.id.rbShopping -> iconIntent.putExtra("icon", "shopping")
                R.id.rbBath -> iconIntent.putExtra("icon", "bath")
                R.id.rbCleanup -> iconIntent.putExtra("icon", "cleanup")
            }

            setResult(RESULT_OK, iconIntent)

            finish()
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