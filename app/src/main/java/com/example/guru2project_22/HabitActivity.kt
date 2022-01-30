package com.example.guru2project_22

import android.app.TimePickerDialog
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
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

        var waterDrawable = getDrawable(R.drawable.water)
        var bedDrawable = getDrawable(R.drawable.bed)
        var computerDrawable = getDrawable(R.drawable.computer)
        var exerciseDrawable = getDrawable(R.drawable.exercise)
        var exercise2Drawable = getDrawable(R.drawable.exercise2)
        var studyDrawable = getDrawable(R.drawable.study)
        var readingDrawable = getDrawable(R.drawable.reading)
        var pillDrawable = getDrawable(R.drawable.pill)
        var mealDrawable = getDrawable(R.drawable.meal)
        var shoppingDrawable = getDrawable(R.drawable.shopping)
        var bathDrawable = getDrawable(R.drawable.bath)
        var cleanupDrawable = getDrawable(R.drawable.cleanup)


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
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }

        if (intent.hasExtra("icon")) {
//            val byteArray = intent.getByteArrayExtra("image")
//            val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
//
//            //되는데 테두리 생김
//            btnIcon.setImageBitmap(bitmap);
            var icon = intent.getStringExtra("icon")

            when(icon) {
                "water" -> btnIcon.setImageDrawable(waterDrawable)
                "bed" -> btnIcon.setImageDrawable(bedDrawable)
                "computer" -> btnIcon.setImageDrawable(computerDrawable)
                "exercise" -> btnIcon.setImageDrawable(exerciseDrawable)
                "exercise2" -> btnIcon.setImageDrawable(exercise2Drawable)
                "study" -> btnIcon.setImageDrawable(studyDrawable)
                "reading" -> btnIcon.setImageDrawable(readingDrawable)
                "pill" -> btnIcon.setImageDrawable(pillDrawable)
                "meal" -> btnIcon.setImageDrawable(mealDrawable)
                "shopping" -> btnIcon.setImageDrawable(shoppingDrawable)
                "bath" -> btnIcon.setImageDrawable(bathDrawable)
                "cleanup" -> btnIcon.setImageDrawable(cleanupDrawable)
            }

        }

    }
}