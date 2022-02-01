package com.example.guru2project_22

import android.app.TimePickerDialog
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import java.text.DecimalFormat
import java.util.*

class SleepActivity : AppCompatActivity() {
    lateinit var btnBack : ImageButton
    lateinit var rbMoon : RadioButton
    lateinit var rbSun : RadioButton
    lateinit var btnStart : Button
    lateinit var btnEnd : Button
    lateinit var rbOn : RadioButton
    lateinit var rbOff : RadioButton
    lateinit var btnComplete : Button

    var timeString = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sleep)

        btnBack = findViewById(R.id.btnBack)
        rbMoon = findViewById(R.id.rbMoon)
        rbSun = findViewById(R.id.rbSun)
        btnStart = findViewById(R.id.btnStart)
        btnEnd = findViewById(R.id.btnEnd)
        rbOn = findViewById(R.id.rbOn)
        rbOff = findViewById(R.id.rbOff)
        btnComplete = findViewById(R.id.btnComplete)

        btnBack.setOnClickListener {
            onBackPressed()
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
}