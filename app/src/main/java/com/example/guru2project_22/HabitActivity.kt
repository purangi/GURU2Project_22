package com.example.guru2project_22

import android.app.Activity
import android.app.AppComponentFactory
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class HabitActivity : AppCompatActivity() {
    lateinit var btnBack : ImageButton
    lateinit var btnIcon : ImageButton
    lateinit var editHabit : EditText
    lateinit var btnStart : Button
    lateinit var btnEnd : Button
    lateinit var cbOneMonth : CheckBox
    lateinit var cbTwoMonth : CheckBox
    lateinit var cbThreeMonth : CheckBox
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
    var iconName = ""

    lateinit var dbManager : DBManager
    lateinit var sqlitedb : SQLiteDatabase

    val ICONSELECT_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habit)

        btnBack = findViewById(R.id.btnBack)
        btnIcon = findViewById(R.id.btnIcon)
        editHabit = findViewById(R.id.editHabit)
        btnStart = findViewById(R.id.btnStart)
        btnEnd = findViewById(R.id.btnEnd)
        cbOneMonth = findViewById(R.id.cbOneMonth)
        cbTwoMonth = findViewById(R.id.cbTwoMonth)
        cbThreeMonth = findViewById(R.id.cbThreeMonth)
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

        // 현재시간을 가져오기
        val now = System.currentTimeMillis()
        val date = Date(now)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale("ko", "KR"))
        val str_date = dateFormat.format(date)

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

        btnComplete.setOnClickListener {
            //필수 선택지들이 입력되지 않았을 시 완료 선택 불가
            //scheduleDB (date text, icon text, habit text, startTime INTEGER, endTime INTEGER, days INTEGER, alarm INTEGER)
            var dateText = str_date
            var iconText = iconName
            var habitText = editHabit.text.toString()
            var startTime = btnStart.text
            var endTime = btnEnd.text
            var days : Int = 1011011 //첫자리가 0인거 지원 x 아마 text로 전향해야할지도
            var alarm = 0 //꺼져있으면 0, 켜져있으면 1


        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK) {
            when(requestCode) {
                ICONSELECT_REQUEST_CODE -> { //아이콘 셀렉터 전달 받았을 시
                    var icon = data?.getStringExtra("icon")
                    iconName = icon.toString()

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

    class DBManager(context: Context, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {
        override fun onCreate(db: SQLiteDatabase?) {
            //날짜, 아이콘 id, 습관 이름, 시작시간, 끝시간, 요일, 알람 여부
            db!!.execSQL("CREATE TABLE scheduleDB (date text, icon text, habit text, startTime INTEGER, endTime INTEGER, days INTEGER, alarm INTEGER)")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            TODO("Not yet implemented")
        }
    }
}