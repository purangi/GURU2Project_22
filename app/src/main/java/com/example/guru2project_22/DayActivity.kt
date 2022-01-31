package com.example.guru2project_22

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate

class DayActivity : AppCompatActivity() {
    private lateinit var dailyPie: PieChart
    lateinit var btnHabit : Button
    lateinit var btnSleep : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day)

        dailyPie = findViewById(R.id.dailyPie) //파이차트 생성
        btnHabit = findViewById<Button>(R.id.btnHabit) //나의 습관 버튼 생성
        btnSleep = findViewById(R.id.btnSleep) //수면 시간 버튼 생성

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
        entries.add(PieEntry(508f, "Coal"))
        entries.add(PieEntry(600f, "Petrolium"))
        entries.add(PieEntry(750f,"Natural Gas"))
        entries.add(PieEntry(508f,"Renewable Energy"))
        entries.add(PieEntry(670f,"Nuclear"))


        // colors
        val colorsItems = ArrayList<Int>()
        for (c in ColorTemplate.VORDIPLOM_COLORS) colorsItems.add(c)
        for (c in ColorTemplate.JOYFUL_COLORS) colorsItems.add(c)
        for (c in ColorTemplate.COLORFUL_COLORS) colorsItems.add(c)
        for (c in ColorTemplate.LIBERTY_COLORS) colorsItems.add(c)
        for (c in ColorTemplate.PASTEL_COLORS) colorsItems.add(c)

        // fill the chart
        val piedataset = PieDataSet(entries,"")
        piedataset.apply {
            colors = colorsItems
            valueTextColor = Color.BLACK
            valueTextSize = 16f
        }

        val pieData = PieData(piedataset)
        dailyPie.apply {
            data = pieData
            description.isEnabled = false
            isRotationEnabled = false
            centerText = "This is Center"
            setEntryLabelColor(Color.BLACK)
            animateY(1400, Easing.EaseInOutQuad)
            animate()
        }


    }

}