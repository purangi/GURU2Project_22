package com.example.guru2project_22

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*


class HabitActivity : AppCompatActivity() {
    lateinit var btnBack : ImageButton
    lateinit var btnIcon : ImageButton
    lateinit var editHabit : EditText
    lateinit var btnStart : Button
    lateinit var btnEnd : Button
    lateinit var rgRepeat : RadioGroup
    lateinit var rbOneMonth : RadioButton
    lateinit var rbTwoMonth : RadioButton
    lateinit var rbThreeMonth : RadioButton
    lateinit var rbDays : RadioButton
    lateinit var btnSun : Button
    lateinit var btnMon : Button
    lateinit var btnTues : Button
    lateinit var btnWed : Button
    lateinit var btnThur : Button
    lateinit var btnFri : Button
    lateinit var btnSat : Button
    lateinit var rgAlarm : RadioGroup
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
        //rgRepeat = findViewById(R.id.rgRepeat)
        //rbOneMonth = findViewById(R.id.rbOneMonth)
        //rbTwoMonth = findViewById(R.id.rbTwoMonth)
        //rbThreeMonth = findViewById(R.id.rbThreeMonth)
        //rbDays = findViewById(R.id.rbDays)
        btnSun = findViewById(R.id.btnSun)
        btnMon = findViewById(R.id.btnMon)
        btnTues = findViewById(R.id.btnTues)
        btnWed = findViewById(R.id.btnWed)
        btnThur = findViewById(R.id.btnThur)
        btnFri = findViewById(R.id.btnFri)
        btnSat = findViewById(R.id.btnSat)
        //rgAlarm = findViewById(R.id.rgAlarm)
        rbOn = findViewById(R.id.rbOn)
        rbOff = findViewById(R.id.rbOff)
        btnComplete = findViewById(R.id.btnComplete)

        rbOff.isChecked = true

        dbManager = DBManager(this, "scheduleDB", null, 1)
        sqlitedb = dbManager.writableDatabase

        // 현재 시간을 가져오기
        val now = System.currentTimeMillis()
        val date = Date(now)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale("ko", "KR"))
        val str_date = dateFormat.format(date)

        var cal : Calendar = Calendar.getInstance();
        cal.setTime(date);
        var dayNum = cal.get(Calendar.DAY_OF_WEEK) //요일 (1:일 ~ 7:토)

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
            //scheduleDB (date text, icon text, habit text, startTime text, endTime text, days text, alarm INTEGER)
            var dateText = str_date
            var iconText = iconName //안쓰고 직접 넣어도..?
            var habitText = editHabit.text.toString()
            var startTime = btnStart.text
            var endTime = btnEnd.text
            //days, alarm 입력
            var days = ""//각 요일이 선택되었으면 0, 아니면 1

            //days 설정
            when(btnSun.isSelected) {
                true -> days += "1"
                false -> days += "2"
            }
            when(btnMon.isSelected) {
                true -> days += "1"
                false -> days += "2"
            }
            when(btnTues.isSelected) {
                true -> days += "1"
                false -> days += "2"
            }
            when(btnWed.isSelected) {
                true -> days += "1"
                false -> days += "2"
            }
            when(btnThur.isSelected) {
                true -> days += "1"
                false -> days += "2"
            }
            when(btnFri.isSelected) {
                true -> days += "1"
                false -> days += "2"
            }
            when(btnSat.isSelected) {
                true -> days += "1"
                false -> days += "2"
            }

            //알람 설정
            var alarm : Int //꺼져있으면 0, 켜져있으면 1

            when(rbOff.isChecked) { //알람 Int 설정
                true -> alarm = 0
                false -> alarm = 1
            }

            //입력값 확인
            if(dateText.isEmpty()) {
                Toast.makeText(this@HabitActivity, "잘못된 접근입니다", Toast.LENGTH_SHORT).show() //나중에는 그냥 오늘 시간 할당으로
            } else if(iconName.isEmpty()) {
                Toast.makeText(this@HabitActivity, "아이콘을 선택해주세요", Toast.LENGTH_SHORT).show()
            } else if(habitText.isEmpty()) {
                Toast.makeText(this@HabitActivity, "가지고 싶은 습관을 입력해주세요", Toast.LENGTH_SHORT).show()
            } else if(startTime==endTime) {
                Toast.makeText(this@HabitActivity, "시작 시간과 끝나는 시간이 같습니다", Toast.LENGTH_SHORT).show()
            } else if((rbOneMonth.isChecked || rbTwoMonth.isChecked || rbThreeMonth.isChecked) && !(btnSun.isSelected || btnMon.isSelected || btnTues.isSelected || btnWed.isSelected || btnThur.isSelected || btnFri.isSelected || btnSat.isSelected)) {
                Toast.makeText(this@HabitActivity, "반복할 요일을 선택해주세요", Toast.LENGTH_SHORT).show()
            } else if(!(rbOneMonth.isChecked || rbTwoMonth.isChecked || rbThreeMonth.isChecked) && (btnSun.isSelected || btnMon.isSelected || btnTues.isSelected || btnWed.isSelected || btnThur.isSelected || btnFri.isSelected || btnSat.isSelected)) {
                Toast.makeText(this@HabitActivity, "반복할 기간을 선택해주세요", Toast.LENGTH_SHORT).show()
            } else if(rgAlarm.isSelected == null) {
                Toast.makeText(this@HabitActivity, "알람 설정 여부를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else { //전부 입력되었으면 데이터 베이스 입력 & day로 인텐트

                //반복 설정 없을 시
                if(!(rbOneMonth.isChecked || rbTwoMonth.isChecked || rbThreeMonth.isChecked) && !(btnSun.isSelected ||
                            btnMon.isSelected || btnTues.isSelected || btnWed.isSelected || btnThur.isSelected || btnFri.isSelected || btnSat.isSelected)){
                    sqlitedb.execSQL("INSERT INTO scheduleDB VALUES ('" + dateText + "', '" + iconText + "', '" + habitText + "', '"
                    + startTime + "' , '" + endTime + "' , '" + days + "' , " + alarm + ")")
                } else { //반복 설정에 따라 db 추가
                    sqlitedb.execSQL("INSERT INTO scheduleDB VALUES ('" + dateText + "', '" + iconText + "', '" + habitText + "', '"
                            + startTime + "' , '" + endTime + "' , '" + days + "' , " + alarm + ")")
                }



                //입력 후 인텐트 이동 및 토스트
                sqlitedb.close()
                Toast.makeText(this, "습관을 입력했습니다.", Toast.LENGTH_SHORT).show()
            }
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
        button.isSelected = button.isSelected != true

    }

    class DBManager(context: Context, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {
        override fun onCreate(db: SQLiteDatabase?) {
            //날짜, 아이콘 id, 습관 이름, 시작시간, 끝시간, 요일, 알람 여부
            db!!.execSQL("CREATE TABLE scheduleDB (date text, icon text, habit text, startTime text, endTime text, days text, alarm INTEGER)")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            //아직 필요성x
        }
    }
}