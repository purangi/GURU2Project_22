package com.example.guru2project_22

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import java.util.*

class HabitActivity : AppCompatActivity() {
    lateinit var btnBack : ImageButton
    lateinit var btnIcon : ImageButton
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
    var timeString = ""

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

        btnBack.setOnClickListener {
            onBackPressed()
        }

        btnIcon.setOnClickListener{
            val iconIntent = Intent(this, IconSelect::class.java)
            startActivity(iconIntent)
        }

        btnStart.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                timeString = "${hourOfDay} : ${minute}"
                btnStart.text = timeString

            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }
    }
}