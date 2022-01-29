package com.example.guru2project_22

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup

class IconSelect : AppCompatActivity() {
    lateinit var rgIcon : RadioGroup
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
    lateinit var btnBack : ImageButton
    lateinit var activeRadioButton : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icon_select)

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

        rbWater.setOnClickListener {
            if(activeRadioButton != null) {
                activeRadioButton.isChecked = false
            }
            rbWater.isChecked = true
            activeRadioButton = rbWater
        }
        rbBed.setOnClickListener {
            if(activeRadioButton != null) {
                activeRadioButton.isChecked = false
            }
            rbBed.isChecked = true
            activeRadioButton = rbBed
        }
        rbComputer.setOnClickListener {
            if(activeRadioButton != null) {
                activeRadioButton.isChecked = false
            }
            rbComputer.isChecked = true
            activeRadioButton = rbComputer
        }
        rbExercise.setOnClickListener {
            if(activeRadioButton != null) {
                activeRadioButton.isChecked = false
            }
            rbExercise.isChecked = true
            activeRadioButton = rbExercise
        }
        rbExercise2.setOnClickListener {
            if(activeRadioButton != null) {
                activeRadioButton.isChecked = false
            }
            rbExercise2.isChecked = true
            activeRadioButton = rbExercise2
        }
        rbStudy.setOnClickListener {
            if(activeRadioButton != null) {
                activeRadioButton.isChecked = false
            }
            rbStudy.isChecked = true
            activeRadioButton = rbStudy
        }
        rbReading.setOnClickListener {
            if(activeRadioButton != null) {
                activeRadioButton.isChecked = false
            }
            rbReading.isChecked = true
            activeRadioButton = rbReading
        }
        rbPill.setOnClickListener {
            if(activeRadioButton != null) {
                activeRadioButton.isChecked = false
            }
            rbPill.isChecked = true
            activeRadioButton = rbPill
        }
        rbMeal.setOnClickListener {
            if(activeRadioButton != null) {
                activeRadioButton.isChecked = false
            }
            rbMeal.isChecked = true
            activeRadioButton = rbMeal
        }
        rbShopping.setOnClickListener {
            if(activeRadioButton != null) {
                activeRadioButton.isChecked = false
            }
            rbShopping.isChecked = true
            activeRadioButton = rbShopping
        }
        rbBath.setOnClickListener {
            if(activeRadioButton != null) {
                activeRadioButton.isChecked = false
            }
            rbBath.isChecked = true
            activeRadioButton = rbBath
        }
        rbCleanup.setOnClickListener {
            if(activeRadioButton != null) {
                activeRadioButton.isChecked = false
            }
            rbCleanup.isChecked = true
            activeRadioButton = rbCleanup
        }

    }
}