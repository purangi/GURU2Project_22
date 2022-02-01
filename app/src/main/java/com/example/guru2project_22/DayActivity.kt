package com.example.guru2project_22

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.fonts.FontFamily
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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

    val startSchedule = 270f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day)

        dailyPie = findViewById(R.id.dailyPie) //파이차트 생성
        btnHabit = findViewById<Button>(R.id.btnHabit) //나의 습관 버튼 생성
        btnSleep = findViewById(R.id.btnSleep) //수면 시간 버튼 생성
        tvDay = findViewById(R.id.tvDay) //오늘 날짜

        var HABIT_CODE = 3
        var SLEEP_CODE = 4

        var today = Calendar.getInstance().time
        var todayFormat = SimpleDateFormat("MM월 dd일")
        tvDay.text = todayFormat.format(today)

        setPieChart()

        btnHabit.setOnClickListener{
            val habitIntent = Intent(this, HabitActivity::class.java)
            startActivityForResult(habitIntent, HABIT_CODE)
        }

        btnSleep.setOnClickListener{
            val sleepIntent = Intent(this, SleepActivity::class.java)
            startActivityForResult(sleepIntent, SLEEP_CODE)
        }

    }

    fun setPieChart()
    {
        dailyPie.setUsePercentValues(true)

        val entries = ArrayList<PieEntry>()
//        val allTime = 1440f
//        val timeSum = 40f + 50f
//        val extraTime = allTime - timeSum //남는 시간
//        val firstExtra = 20f
//        val secondExtra = 0f
        if(entries.isEmpty()) {
            entries.add(PieEntry(1440f, "일정이 없습니다."))
        } else {

        }
//        entries.add(PieEntry(extraTime, ""))
//        entries.add(PieEntry(40f, "장보기"))
//        entries.add(PieEntry(firstExtra, ""))
//        entries.add(PieEntry(50f, "책 읽기"))
//        entries.add(PieEntry(secondExtra, ""))
//        entries.add(PieEntry(20f, "6 ~ 8"))
//        entries.add(PieEntry(40f, "8 ~ 12"))
//        entries.add(PieEntry(40f, "12 ~ 16"))
//        entries.add(PieEntry(60f, "16 ~ 22"))

        // colors
        val colorsItems = ArrayList<Int>()
        var colorArray = arrayOf(
            Color.rgb(233, 232, 232), //기본 회색
            Color.rgb(192, 255, 140), Color.rgb(233, 232, 232),
            Color.rgb(255, 247, 140), Color.rgb(233, 232, 232),
            Color.rgb(255, 208, 140), Color.rgb(233, 232, 232),
            Color.rgb(140, 234, 255), Color.rgb(233, 232, 232),
            Color.rgb(255, 140, 157), Color.rgb(233, 232, 232)
        )
        for (c in colorArray) colorsItems.add(c)

        // fill the chart
        val piedataset = PieDataSet(entries, "")
        piedataset.apply {
            colors = colorsItems
            valueTextColor = Color.TRANSPARENT
            valueTextSize = 16f
        }

        val pieData = PieData(piedataset)

        dailyPie.apply {
            rotationAngle = startSchedule
            data = pieData
            description.isEnabled = false
            isRotationEnabled = false
            isDrawHoleEnabled = false
            legend.isEnabled = false

            val typeface = Typeface.createFromAsset(assets, "zzanggu.ttf");
            setEntryLabelTypeface(typeface)

            setEntryLabelColor(Color.BLACK)
            animateY(1400, Easing.EaseInOutQuad)
            animate()
        }


    }

}