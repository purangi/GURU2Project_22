package com.example.guru2project_22

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
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

    val ICONSELECT_REQUEST_CODE = 0

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
            startActivityForResult(iconIntent, ICONSELECT_REQUEST_CODE)
        }

        btnStart.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                val hourFormat = DecimalFormat("00")
                val minuteFormat = DecimalFormat("00")
                timeString = hourFormat.format(hourOfDay).toString() + " : " +  minuteFormat.format(minute).toString()
                btnStart.text = timeString

            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }

        btnEnd.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                val hourFormat = DecimalFormat("00")
                val minuteFormat = DecimalFormat("00")
                timeString = hourFormat.format(hourOfDay).toString() + " : " +  minuteFormat.format(minute).toString()
                btnEnd.text = timeString

            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK) {
            when(requestCode) {
                ICONSELECT_REQUEST_CODE -> { //아이콘 셀렉터 전달 받았을 시
                    var icon = data?.getStringExtra("icon")

                    when(icon) {
                        "water" -> btnIcon.setImageDrawable(getDrawable(R.drawable.water))
                        "bed" -> btnIcon.setImageDrawable(getDrawable(R.drawable.bed))
                        "computer" -> btnIcon.setImageDrawable(getDrawable(R.drawable.computer))
                        "exercise" -> btnIcon.setImageDrawable(getDrawable(R.drawable.exercise))
                        "exercise2" -> btnIcon.setImageDrawable(getDrawable(R.drawable.exercise2))
                        "study" -> btnIcon.setImageDrawable(getDrawable(R.drawable.study))
                        "reading" -> btnIcon.setImageDrawable(getDrawable(R.drawable.reading))
                        "pill" -> btnIcon.setImageDrawable(getDrawable(R.drawable.pill))
                        "meal" -> btnIcon.setImageDrawable(getDrawable(R.drawable.meal))
                        "shopping" -> btnIcon.setImageDrawable(getDrawable(R.drawable.shopping))
                        "bath" -> btnIcon.setImageDrawable(getDrawable(R.drawable.bath))
                        "cleanup" -> btnIcon.setImageDrawable(getDrawable(R.drawable.cleanup))

                    }
                }
            }
        }
    }

    fun clickBtn(view: View) {
        var button = view as Button
        button?.isSelected = button?.isSelected != true

    }
}