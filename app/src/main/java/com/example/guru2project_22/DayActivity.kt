package com.example.guru2project_22

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class DayActivity : AppCompatActivity() {
    private lateinit var dailyPie: PieChart
    lateinit var btnHabit : Button
    lateinit var btnSleep : Button
    lateinit var tvDay : TextView

    lateinit var dbManager : HabitActivity.DBManager
    lateinit var sqlitedb : SQLiteDatabase

    var pieStartAngle : Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day)

        dailyPie = findViewById(R.id.dailyPie) //파이차트 생성
        btnHabit = findViewById<Button>(R.id.btnHabit) //나의 습관 버튼 생성
        btnSleep = findViewById(R.id.btnSleep) //수면 시간 버튼 생성
        tvDay = findViewById(R.id.tvDay) //오늘 날짜

        dbManager = HabitActivity.DBManager(this, "scheduleDB", null, 1)
        sqlitedb = dbManager.readableDatabase
        var cursor : Cursor


        var today = Calendar.getInstance().time
        var textDayFormat = SimpleDateFormat("MM월 dd일")
        tvDay.text = textDayFormat.format(today) //날짜 표시용
        var dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val dateText = dateFormat.format(today) //데이터 비교용
        //시작 시간 순 정렬
        cursor = sqlitedb.rawQuery("SELECT * FROM scheduleDB WHERE date = '"+dateText+"' ORDER BY startTime", null)

        if(cursor.moveToFirst()) {
            var startTime = cursor.getString(cursor.getColumnIndex("startTime")).toString()
            var timeArray = startTime.split(" : ")
            pieStartAngle = ((timeArray[0].toInt() * 60 + timeArray[1].toInt()).toFloat() * 0.25f) - 90f
        }
        while(cursor.moveToNext()) {
            var icon = cursor.getString(cursor.getColumnIndex("icon")).toString()
            var habit = cursor.getString(cursor.getColumnIndex("habit")).toString()
            var startTime = cursor.getString(cursor.getColumnIndex("startTime")).toString()
            var endTime = cursor.getString(cursor.getColumnIndex("endTime")).toString()
        }

        setPieChart()

        btnHabit.setOnClickListener{
            val habitIntent = Intent(this, HabitActivity::class.java)
            startActivity(habitIntent)
        }

        btnSleep.setOnClickListener{
            val sleepIntent = Intent(this, SleepActivity::class.java)
            startActivity(sleepIntent)
        }

    }

    fun setPieChart()
    {
        dailyPie.setUsePercentValues(true)

        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(80f, "22 ~ 6"))
        entries.add(PieEntry(20f, "6 ~ 8"))
        entries.add(PieEntry(40f, "8 ~ 12"))
        entries.add(PieEntry(40f, "12 ~ 16"))
        entries.add(PieEntry(60f, "16 ~ 22"))

        // colors
        val colorsItems = ArrayList<Int>()
        for (c in ColorTemplate.VORDIPLOM_COLORS) colorsItems.add(c)

        // fill the chart
        val piedataset = PieDataSet(entries,"")
        piedataset.apply {
            colors = colorsItems
            valueTextColor = Color.TRANSPARENT
            valueTextSize = 16f
        }

        val pieData = PieData(piedataset)

        dailyPie.apply {
            rotationAngle = pieStartAngle
            data = pieData
            description.isEnabled = false
            isRotationEnabled = false
            isDrawHoleEnabled = false
            legend.isEnabled = false

            setEntryLabelColor(Color.BLACK)
            animateY(1400, Easing.EaseInOutQuad)
            animate()
        }


    }

}