package com.example.guru2project_22

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class DayActivity : AppCompatActivity() {
    private lateinit var dailyPie: PieChart
    lateinit var btnHabit : Button
    lateinit var btnSleep : Button
    lateinit var tvDay : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day)

        dailyPie = findViewById(R.id.dailyPie) //파이차트 생성
        btnHabit = findViewById<Button>(R.id.btnHabit) //나의 습관 버튼 생성
        btnSleep = findViewById(R.id.btnSleep) //수면 시간 버튼 생성
        tvDay = findViewById(R.id.tvDay) //오늘 날짜

        var today = Calendar.getInstance().time
        var todayFormat = SimpleDateFormat("MM월 dd일")
        tvDay.text = todayFormat.format(today)

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
            rotationAngle = 240f
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