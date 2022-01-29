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
        // xvalues
        val xvalues = ArrayList<String>()
        xvalues.add("Coal")
        xvalues.add("Petrolium")
        xvalues.add("Natural Gas")
        xvalues.add("Renewable Energy")
        xvalues.add("Nuclear")


        // yvalues
        val piechartentry = ArrayList<PieEntry>()


        piechartentry.add(PieEntry(23.5f, 0))
        piechartentry.add(PieEntry(45.5f, 1))
        piechartentry.add(PieEntry(68.5f, 2))






        // fill the chart
        val piedataset = PieDataSet(piechartentry," Consumption")

        piedataset.color= resources.getColor(R.color.main_beige)


        piedataset.sliceSpace=3f
        val data = PieData(piedataset)
        dailyPie.data = data


        dailyPie.holeRadius = 5f
        dailyPie.setBackgroundColor(resources.getColor(R.color.main_orange))


    }

}