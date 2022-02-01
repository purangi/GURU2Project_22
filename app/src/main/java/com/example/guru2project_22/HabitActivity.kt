package com.example.guru2project_22

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
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
    lateinit var btnComplete : Button

    var timeString = ""
    var currentTime = ""
    var icon = ""

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
        btnComplete = findViewById(R.id.btnComplete)

        var cal = Calendar.getInstance() //나중에는 해당 스케줄러의 날짜 받아오는 것으로 수정
        cal.time = Date()
        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        currentTime = df.format(cal.time)

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
//        //매일 클릭 됐을 시 요일 전부 다 불들어오는거랑 요일 전부 클릭됐을 시 매일 불들어오는거 안먹힘
//        if(cbEveryDay.isChecked()) {
//            btnSun.isSelected = true
//            btnMon.isSelected = true
//            btnTues.isSelected = true
//            btnWed.isSelected = true
//            btnThur.isSelected = true
//            btnFri.isSelected = true
//            btnSat.isSelected = true
//        }
//        if(btnSun.isSelected && btnMon.isSelected && btnTues.isSelected && btnWed.isSelected && btnThur.isSelected
//            && btnFri.isSelected && btnSat.isSelected) {
//            cbEveryDay.isChecked = true
//        }

        btnComplete.setOnClickListener {

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK) {
            when(requestCode) {
                ICONSELECT_REQUEST_CODE -> { //아이콘 셀렉터 전달 받았을 시
                    icon = data?.getStringExtra("icon").toString()

                    when(icon) { //아이콘 이름에 따라 아이콘 모양 출력
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

    inner class DBManager(context: Context, name : String?, factory : SQLiteDatabase.CursorFactory, version : Int) : SQLiteOpenHelper(context, "scheduleDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase?) {
            //scheduleDB(날짜, 아이콘 이미지id, 습관, 시작 시간, 끝 시간, 알람 여부)
            db!!.execSQL("CREATE TABLE scheduleDB (date text, icon text, habit text, startTime INTEGER, endTime INTEGER, alarm INTEGER)")
        }
        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            TODO("Not yet implemented")
        }
    }
}