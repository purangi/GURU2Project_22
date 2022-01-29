package com.example.guru2project_22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton

class HabitActivity : AppCompatActivity() {
    lateinit var btnBack : Button
    lateinit var btnIcon : Button
    lateinit var editHabit : EditText
    lateinit var btnStart : Button
    lateinit var btnEnd : Button
    lateinit var cbEveryDay : CheckBox
    lateinit var cbEveryWeek : CheckBox
    lateinit var cbEveryMonth : CheckBox
    lateinit var btnSun : Button
    lateinit var btnMon : Button
    lateinit var btnTues : Button
    lateinit var btnWed : Button
    lateinit var btnThur : Button
    lateinit var btnFri : Button
    lateinit var btnSat : Button
    lateinit var rbOn : RadioButton
    lateinit var rbOff : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habit)

        btnBack = findViewById(R.id.btnBack)
        btnIcon = findViewById(R.id.btnIcon)
        editHabit = findViewById(R.id.editHabit)
        btnStart = findViewById(R.id.btnStart)
        btnEnd = findViewById(R.id.btnEnd)
        cbEveryDay = findViewById(R.id.cbEveryDay)
        cbEveryWeek = findViewById(R.id.cbEveryWeek)
        cbEveryMonth = findViewById(R.id.cbEveryMonth)
        btnSun = findViewById(R.id.btnSun)
        btnMon = findViewById(R.id.btnMon)
        btnTues = findViewById(R.id.btnTues)
        btnWed = findViewById(R.id.btnWed)
        btnThur = findViewById(R.id.btnThur)
        btnFri = findViewById(R.id.btnFri)
        btnSat = findViewById(R.id.btnSat)
        rbOn = findViewById(R.id.rbOn)
        rbOff = findViewById(R.id.rbOff)

    }
}