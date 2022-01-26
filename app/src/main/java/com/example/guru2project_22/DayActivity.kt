package com.example.guru2project_22

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter

class DayActivity : AppCompatActivity() {
    private lateinit var dailyPie: PieChart


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day)

        dailyPie = findViewById(R.id.dailyPie) //파이차트 생성

        initPieChart()
        setDataToPieChart()
    }

    private fun initPieChart() {
        dailyPie.setUsePercentValues(true)
        dailyPie.description.text = ""
        //hollow pie chart
        dailyPie.isDrawHoleEnabled = false
        dailyPie.setTouchEnabled(false)
        dailyPie.setDrawEntryLabels(false)
        //adding padding
        dailyPie.setExtraOffsets(20f, 0f, 20f, 20f)
        dailyPie.setUsePercentValues(true)
        dailyPie.isRotationEnabled = false
        dailyPie.setDrawEntryLabels(false)
        dailyPie.legend.orientation = Legend.LegendOrientation.VERTICAL
        dailyPie.legend.isWordWrapEnabled = true
    }

    private fun setDataToPieChart() {
        dailyPie.setUsePercentValues(true)
        val dataEntries = ArrayList<PieEntry>()
        dataEntries.add(PieEntry(72f, "Android"))
        dataEntries.add(PieEntry(26f, "Ios"))
        dataEntries.add(PieEntry(2f, "Other"))

        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#4DD0E1"))
        colors.add(Color.parseColor("#FFF176"))
        colors.add(Color.parseColor("#FF8A65"))

        val dataSet = PieDataSet(dataEntries, "")
        val data = PieData(dataSet)

        // In Percentage
        data.setValueFormatter(PercentFormatter())
        dataSet.sliceSpace = 3f
        dataSet.colors = colors

        dailyPie.data = data
        data.setValueTextSize(15f)
        dailyPie.setExtraOffsets(5f, 10f, 5f, 5f)
        dailyPie.animateY(1400, Easing.EaseInOutQuad)

        //create hole in center
        dailyPie.holeRadius = 58f
        dailyPie.transparentCircleRadius = 61f
        dailyPie.isDrawHoleEnabled = true
        dailyPie.setHoleColor(Color.WHITE)


        //add text in center
        dailyPie.setDrawCenterText(true);
        dailyPie.centerText = "Mobile OS Market share"

        dailyPie.invalidate()
    }

}