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
import androidx.core.app.ActivityCompat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*


class HabitActivity : AppCompatActivity() {
    lateinit var btnBack: ImageButton
    lateinit var btnIcon: ImageButton
    lateinit var editHabit: EditText
    lateinit var btnStart: Button
    lateinit var btnEnd: Button
    lateinit var rgRepeat: RadioGroup
    lateinit var rbOneMonth: RadioButton
    lateinit var rbTwoMonth: RadioButton
    lateinit var rbThreeMonth: RadioButton
    lateinit var rbDays: RadioButton
    lateinit var btnSun: Button
    lateinit var btnMon: Button
    lateinit var btnTues: Button
    lateinit var btnWed: Button
    lateinit var btnThur: Button
    lateinit var btnFri: Button
    lateinit var btnSat: Button
    lateinit var rgAlarm: RadioGroup
    lateinit var rbOn: RadioButton
    lateinit var rbOff: RadioButton
    lateinit var btnComplete: Button
    var timeString = ""
    var iconName = ""

    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase

    val ICONSELECT_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habit)

        btnBack = findViewById(R.id.btnBack)
        btnIcon = findViewById(R.id.btnIcon)
        editHabit = findViewById(R.id.editHabit)
        btnStart = findViewById(R.id.btnStart)
        btnEnd = findViewById(R.id.btnEnd)
        rgRepeat = findViewById(R.id.rgRepeat)
        rbOneMonth = findViewById(R.id.rbOneMonth)
        rbTwoMonth = findViewById(R.id.rbTwoMonth)
        rbThreeMonth = findViewById(R.id.rbThreeMonth)
        rbDays = findViewById(R.id.rbDays)
        btnSun = findViewById(R.id.btnSun)
        btnMon = findViewById(R.id.btnMon)
        btnTues = findViewById(R.id.btnTues)
        btnWed = findViewById(R.id.btnWed)
        btnThur = findViewById(R.id.btnThur)
        btnFri = findViewById(R.id.btnFri)
        btnSat = findViewById(R.id.btnSat)
        rgAlarm = findViewById(R.id.rgAlarm)
        rbOn = findViewById(R.id.rbOn)
        rbOff = findViewById(R.id.rbOff)
        btnComplete = findViewById(R.id.btnComplete)

        rbOff.isChecked = true

        dbManager = DBManager(this, "scheduleDB", null, 1)
        sqlitedb = dbManager.writableDatabase

        btnBack.setOnClickListener {
            onBackPressed()
        }

        btnIcon.setOnClickListener {
            val iconIntent = Intent(this, IconSelect::class.java)
            startActivityForResult(iconIntent, ICONSELECT_REQUEST_CODE)
        }

        btnStart.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                val hourFormat = DecimalFormat("00")
                val minuteFormat = DecimalFormat("00")
                timeString =
                    hourFormat.format(hourOfDay).toString() + " : " + minuteFormat.format(minute)
                        .toString()
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
                timeString =
                    hourFormat.format(hourOfDay).toString() + " : " + minuteFormat.format(minute)
                        .toString()
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
            //?????? ??????????????? ???????????? ????????? ??? ?????? ?????? ??????
            //scheduleDB (date text, icon text, habit text, startTime text, endTime text, days text, alarm INTEGER)
            var iconText = iconName //????????? ?????? ?????????..?
            var habitText = editHabit.text.toString()
            var startTime = btnStart.text
            var endTime = btnEnd.text
            //?????? ??????
            var alarm: Int //??????????????? 0, ??????????????? 1

            when (rbOff.isChecked) { //?????? Int ??????
                true -> alarm = 0
                false -> alarm = 1
            }

            // ?????? ?????? ????????????
            var cal: Calendar = Calendar.getInstance()
            var date = cal.time
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale("ko", "KR"))
            var dateText = dateFormat.format(date)

            if(intent.hasExtra("dateonDay")) {
                dateText = intent.getStringExtra("dateonDay")
            }

            cal.time = dateFormat.parse(dateText)

            val dayNum = cal.get(Calendar.DAY_OF_WEEK) //?????? (1:??? ~ 7:???)

            //????????? ??????
            if (dateText.isEmpty()) {
                Toast.makeText(this@HabitActivity, "????????? ???????????????", Toast.LENGTH_SHORT)
                    .show() //???????????? ?????? ?????? ?????? ????????????
            } else if (iconName.isEmpty()) {
                Toast.makeText(this@HabitActivity, "???????????? ??????????????????", Toast.LENGTH_SHORT).show()
            } else if (habitText.isEmpty()) {
                Toast.makeText(this@HabitActivity, "????????? ?????? ????????? ??????????????????", Toast.LENGTH_SHORT).show()
            } else if (startTime == endTime) {
                Toast.makeText(this@HabitActivity, "?????? ????????? ????????? ????????? ????????????", Toast.LENGTH_SHORT).show()
            } else if ((rbOneMonth.isChecked || rbTwoMonth.isChecked || rbThreeMonth.isChecked) && !(btnSun.isSelected || btnMon.isSelected || btnTues.isSelected || btnWed.isSelected || btnThur.isSelected || btnFri.isSelected || btnSat.isSelected)) {
                Toast.makeText(this@HabitActivity, "????????? ????????? ??????????????????", Toast.LENGTH_SHORT).show()
            } else if (!(rbOneMonth.isChecked || rbTwoMonth.isChecked || rbThreeMonth.isChecked) && (btnSun.isSelected || btnMon.isSelected || btnTues.isSelected || btnWed.isSelected || btnThur.isSelected || btnFri.isSelected || btnSat.isSelected)) {
                Toast.makeText(this@HabitActivity, "????????? ????????? ??????????????????", Toast.LENGTH_SHORT).show()
            } else { //?????? ?????????????????? ????????? ????????? ?????? & day??? ?????????
                //?????? ?????? ?????? ???
                if (!(rbOneMonth.isChecked || rbTwoMonth.isChecked || rbThreeMonth.isChecked) && !(btnSun.isSelected ||
                            btnMon.isSelected || btnTues.isSelected || btnWed.isSelected || btnThur.isSelected || btnFri.isSelected || btnSat.isSelected)
                ) {
                    sqlitedb.execSQL(
                        "INSERT INTO scheduleDB VALUES ('" + dateText + "', '" + iconText + "', '" + habitText + "', '"
                                + startTime + "' , '" + endTime + "' , " + alarm + ")"
                    )
                } else { //?????? ????????? ?????? db ??????
                    //??????
                    var term: Int
                    if (rbOneMonth.isChecked) {
                        term = 30
                    } else if (rbTwoMonth.isChecked) {
                        term = 60
                    } else if (rbThreeMonth.isChecked) {
                        term = 90
                    } else {
                        term = 0
                    }

                    if (btnSun.isSelected) {
                        var i = 0
                        while (((1 - dayNum) + 7 * i) <= term) {
                            cal.add(Calendar.DATE, (1 - dayNum) + 7 * i)
                            dateText = dateFormat.format(cal.time)
                            sqlitedb.execSQL(
                                "INSERT INTO scheduleDB VALUES ('" + dateText + "', '" + iconText + "', '" + habitText + "', '"
                                        + startTime + "' , '" + endTime + "' , " + alarm + ")"
                            )
                            cal.add(Calendar.DATE, -((1 - dayNum) + 7 * i))
                            i++
                        }
                    }
                    if (btnMon.isSelected) {
                        if (2 < dayNum) {
                            var i = 0
                            while (((9 - dayNum) + 7 * i) <= term) {
                                cal.add(Calendar.DATE, (9 - dayNum) + 7 * i)
                                dateText = dateFormat.format(cal.time)
                                sqlitedb.execSQL(
                                    "INSERT INTO scheduleDB VALUES ('" + dateText + "', '" + iconText + "', '" + habitText + "', '"
                                            + startTime + "' , '" + endTime + "' , " + alarm + ")"
                                )
                                cal.add(Calendar.DATE, -((9 - dayNum) + 7 * i))
                                i++
                            }
                        } else {
                            var i = 0
                            while (((2 - dayNum) + 7 * i) <= term) {
                                cal.add(Calendar.DATE, (2 - dayNum) + 7 * i)
                                dateText = dateFormat.format(cal.time)
                                sqlitedb.execSQL(
                                    "INSERT INTO scheduleDB VALUES ('" + dateText + "', '" + iconText + "', '" + habitText + "', '"
                                            + startTime + "' , '" + endTime + "' , " + alarm + ")"
                                )
                                cal.add(Calendar.DATE, -((2 - dayNum) + 7 * i))
                                i++
                            }
                        }
                    }
                    if (btnTues.isSelected) {
                        if (3 < dayNum) {
                            var i = 0
                            while (((10 - dayNum) + 7 * i) <= term) {
                                cal.add(Calendar.DATE, (10 - dayNum) + 7 * i)
                                dateText = dateFormat.format(cal.time)
                                sqlitedb.execSQL(
                                    "INSERT INTO scheduleDB VALUES ('" + dateText + "', '" + iconText + "', '" + habitText + "', '"
                                            + startTime + "' , '" + endTime + "' , " + alarm + ")"
                                )
                                cal.add(Calendar.DATE, -((10 - dayNum) + 7 * i))
                                i++
                            }
                        } else {
                            var i = 0
                            while (((3 - dayNum) + 7 * i) <= term) {
                                cal.add(Calendar.DATE, (3 - dayNum) + 7 * i)
                                dateText = dateFormat.format(cal.time)
                                sqlitedb.execSQL(
                                    "INSERT INTO scheduleDB VALUES ('" + dateText + "', '" + iconText + "', '" + habitText + "', '"
                                            + startTime + "' , '" + endTime + "' , " + alarm + ")"
                                )
                                cal.add(Calendar.DATE, -((3 - dayNum) + 7 * i))
                                i++
                            }
                        }
                    }
                    if (btnWed.isSelected) {
                        if (4 < dayNum) {
                            var i = 0
                            while (((11 - dayNum) + 7 * i) <= term) {
                                cal.add(Calendar.DATE, (11 - dayNum) + 7 * i)
                                dateText = dateFormat.format(cal.time)
                                sqlitedb.execSQL(
                                    "INSERT INTO scheduleDB VALUES ('" + dateText + "', '" + iconText + "', '" + habitText + "', '"
                                            + startTime + "' , '" + endTime + "' , " + alarm + ")"
                                )
                                cal.add(Calendar.DATE, -((11 - dayNum) + 7 * i))
                                i++
                            }
                        } else {
                            var i = 0
                            while (((4 - dayNum) + 7 * i) <= term) {
                                cal.add(Calendar.DATE, (4 - dayNum) + 7 * i)
                                dateText = dateFormat.format(cal.time)
                                sqlitedb.execSQL(
                                    "INSERT INTO scheduleDB VALUES ('" + dateText + "', '" + iconText + "', '" + habitText + "', '"
                                            + startTime + "' , '" + endTime + "' , " + alarm + ")"
                                )
                                cal.add(Calendar.DATE, -((4 - dayNum) + 7 * i))
                                i++
                            }
                        }
                    }
                    if (btnThur.isSelected) {
                        if (5 < dayNum) {
                            var i = 0
                            while (((12 - dayNum) + 7 * i) <= term) {
                                cal.add(Calendar.DATE, (12 - dayNum) + 7 * i)
                                dateText = dateFormat.format(cal.time)
                                sqlitedb.execSQL(
                                    "INSERT INTO scheduleDB VALUES ('" + dateText + "', '" + iconText + "', '" + habitText + "', '"
                                            + startTime + "' , '" + endTime + "' , " + alarm + ")"
                                )
                                cal.add(Calendar.DATE, -((12 - dayNum) + 7 * i))
                                i++
                            }
                        } else {
                            var i = 0
                            while (((5 - dayNum) + 7 * i) <= term) {
                                cal.add(Calendar.DATE, (5 - dayNum) + 7 * i)
                                dateText = dateFormat.format(cal.time)
                                sqlitedb.execSQL(
                                    "INSERT INTO scheduleDB VALUES ('" + dateText + "', '" + iconText + "', '" + habitText + "', '"
                                            + startTime + "' , '" + endTime + "' , " + alarm + ")"
                                )
                                cal.add(Calendar.DATE, -((5 - dayNum) + 7 * i))
                                i++
                            }
                        }
                    }
                    if (btnFri.isSelected) {
                        if (6 < dayNum) {
                            var i = 0
                            while (((13 - dayNum) + 7 * i) <= term) {
                                cal.add(Calendar.DATE, (13 - dayNum) + 7 * i)
                                dateText = dateFormat.format(cal.time)
                                sqlitedb.execSQL(
                                    "INSERT INTO scheduleDB VALUES ('" + dateText + "', '" + iconText + "', '" + habitText + "', '"
                                            + startTime + "' , '" + endTime + "' , " + alarm + ")"
                                )
                                cal.add(Calendar.DATE, -((13 - dayNum) + 7 * i))
                                i++
                            }
                        } else {
                            var i = 0
                            while (((6 - dayNum) + 7 * i) <= term) {
                                cal.add(Calendar.DATE, (6 - dayNum) + 7 * i)
                                dateText = dateFormat.format(cal.time)
                                sqlitedb.execSQL(
                                    "INSERT INTO scheduleDB VALUES ('" + dateText + "', '" + iconText + "', '" + habitText + "', '"
                                            + startTime + "' , '" + endTime + "' , " + alarm + ")"
                                )
                                cal.add(Calendar.DATE, -((6 - dayNum) + 7 * i))
                                i++
                            }
                        }
                    }
                    if (btnSat.isSelected) {
                        var i = 0
                        while (((7 - dayNum) + 7 * i) <= term) {
                            cal.add(Calendar.DATE, (7 - dayNum) + 7 * i)
                            dateText = dateFormat.format(cal.time)
                            sqlitedb.execSQL(
                                "INSERT INTO scheduleDB VALUES ('" + dateText + "', '" + iconText + "', '" + habitText + "', '"
                                        + startTime + "' , '" + endTime + "' , " + alarm + ")"
                            )
                            cal.add(Calendar.DATE, -((7 - dayNum) + 7 * i))
                            i++
                        }
                    }
                }

                //?????? ??? ????????? ?????? ??? ?????????
                sqlitedb.close()
                dbManager.close()
                Toast.makeText(this, "????????? ??????????????????.", Toast.LENGTH_SHORT).show()
                val dayIntent = Intent(this, DayActivity::class.java)
                finishAffinity()
                startActivity(dayIntent)
                finish()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                ICONSELECT_REQUEST_CODE -> { //????????? ????????? ?????? ????????? ???
                    var icon = data?.getStringExtra("icon")
                    iconName = icon.toString()

                    when (icon) {
                        "water" -> {
                            btnIcon.setImageDrawable(getDrawable(R.drawable.water))
                        }
                        "bed" -> {
                            btnIcon.setImageDrawable(getDrawable(R.drawable.bed))
                        }
                        "computer" -> {
                            btnIcon.setImageDrawable(getDrawable(R.drawable.computer))
                        }
                        "exercise" -> {
                            btnIcon.setImageDrawable(getDrawable(R.drawable.exercise))
                        }
                        "sleep" -> {
                            btnIcon.setImageDrawable(getDrawable(R.drawable.moon))
                        }
                        "study" -> {
                            btnIcon.setImageDrawable(getDrawable(R.drawable.study))
                        }
                        "reading" -> {
                            btnIcon.setImageDrawable(getDrawable(R.drawable.reading))
                        }
                        "pill" -> {
                            btnIcon.setImageDrawable(getDrawable(R.drawable.pill))
                        }
                        "meal" -> {
                            btnIcon.setImageDrawable(getDrawable(R.drawable.meal))
                        }
                        "shopping" -> {
                            btnIcon.setImageDrawable(getDrawable(R.drawable.shopping))
                        }
                        "bath" -> {
                            btnIcon.setImageDrawable(getDrawable(R.drawable.bath))
                        }
                        "cleanup" -> {
                            btnIcon.setImageDrawable(getDrawable(R.drawable.cleanup))
                        }
                    }
                }
            }
        }
    }

    fun clickBtn(view: View) {
        var button = view as Button
        button.isSelected = button.isSelected != true

    }

    class DBManager(
        context: Context,
        name: String?,
        factory: SQLiteDatabase.CursorFactory?,
        version: Int
    ) : SQLiteOpenHelper(context, name, factory, version) {
        override fun onCreate(db: SQLiteDatabase?) {
            //??????, ????????? id, ?????? ??????, ????????????, ?????????, ??????, ?????? ??????
            db!!.execSQL("CREATE TABLE scheduleDB (date text, icon text, habit text, startTime text, endTime text, alarm INTEGER)")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            //?????? ?????????x
        }
    }
}