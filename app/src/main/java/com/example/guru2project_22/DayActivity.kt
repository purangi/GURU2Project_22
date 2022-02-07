package com.example.guru2project_22

import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class DayActivity : AppCompatActivity() {
    private lateinit var dailyPie: PieChart
    lateinit var btnHabit : Button
    lateinit var tvDay : TextView
    lateinit var navday: ImageButton
    lateinit var navhome: ImageButton
    lateinit var navmypage: ImageButton

    lateinit var dbManager : HabitActivity.DBManager
    lateinit var sqlitedb : SQLiteDatabase

    var pieStartAngle : Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day)

        dailyPie = findViewById(R.id.dailyPie) //파이차트 생성
        btnHabit = findViewById<Button>(R.id.btnHabit) //습관 추가 버튼 생성
        tvDay = findViewById(R.id.tvDay) //오늘 날짜

        dbManager = HabitActivity.DBManager(this, "scheduleDB", null, 1)
        sqlitedb = dbManager.readableDatabase
        var cursor : Cursor

        //네비게이션 버튼
        navday.setOnClickListener {
            val intent = Intent(this, DayActivity::class.java)
            startActivity(intent)
        }

        navhome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        navmypage.setOnClickListener {
            val intent = Intent(this, MyPage::class.java)
            startActivity(intent)
        }


        var today = Calendar.getInstance().time
        var textDayFormat = SimpleDateFormat("MM월 dd일")
        tvDay.text = textDayFormat.format(today) //날짜 표시용
        var dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val dateText = dateFormat.format(today) //데이터 비교용
        //시작 시간 순 정렬
        cursor = sqlitedb.rawQuery(
            "SELECT * FROM scheduleDB WHERE date = '" + dateText + "' ORDER BY startTime",
            null
        )

        dailyPie.setUsePercentValues(true)

        val entries = ArrayList<PieEntry>()
        var sum = 0f

        while(cursor.moveToNext()) {
            var habit = cursor.getString(cursor.getColumnIndex("habit")).toString()
            var startTime = cursor.getString(cursor.getColumnIndex("startTime")).toString()
            var endTime = cursor.getString(cursor.getColumnIndex("endTime")).toString()

            var startArray = startTime.split(" : ")
            var endArray = endTime.split(" : ")
            if(cursor.isFirst) { //startAngle을 가장 첫 column 기준으로 설정
                pieStartAngle = ((startArray[0].toInt() * 60 + startArray[1].toInt()).toFloat() * 0.25f) - 90f
            }
            var pieValue = (endArray[0].toFloat() * 60 + endArray[1].toFloat()) - (startArray[0].toFloat() * 60 + startArray[1].toFloat())

            entries.add(PieEntry(pieValue, habit)) //기본 일정 추가
            Log.v("test", habit + " " + startTime + " " + endTime)
            Log.v("value", pieValue.toString())

            sum += pieValue

            //빈 일정 추가
            if(!cursor.isLast) {
                cursor.moveToNext()

                var nextStart = cursor.getString(cursor.getColumnIndex("startTime")).toString()
                var nextStartArray = nextStart.split(" : ")
                var emptyValue = (nextStartArray[0].toFloat() * 60 + nextStartArray[1].toFloat()) - (endArray[0].toFloat() * 60 + endArray[1].toFloat())
                entries.add(PieEntry(emptyValue, ""))

                Log.v("empty value", emptyValue.toString())

                sum += emptyValue

                cursor.moveToPrevious()
            } else {
                entries.add(PieEntry(1440f - sum, ""))
                Log.v("empty value", (1440f - sum).toString())
            }
        }

        // colors
        val colorsItems = ArrayList<Int>()
        val pieColors = intArrayOf(
            Color.rgb(192, 255, 140), Color.rgb(255, 255, 255),
            Color.rgb(255, 247, 140), Color.rgb(255, 255, 255),
            Color.rgb(255, 208, 140), Color.rgb(255, 255, 255),
            Color.rgb(140, 234, 255), Color.rgb(255, 255, 255),
            Color.rgb(255, 140, 157), Color.rgb(255, 255, 255)
        )
        for (c in pieColors) colorsItems.add(c)

        // fill the chart
        val piedataset = PieDataSet(entries, "")
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

        btnHabit.setOnClickListener{
            val habitIntent = Intent(this, HabitActivity::class.java)
            startActivity(habitIntent)
        }

        sqlitedb.close()
        dbManager.close()
        cursor.close()
    }

}