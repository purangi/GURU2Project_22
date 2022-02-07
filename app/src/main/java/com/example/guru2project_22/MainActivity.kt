package com.example.guru2project_22

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private val DayActivity = DayActivity()
    lateinit var catbutton: ImageButton
    lateinit var navday: ImageButton
    lateinit var navhome: ImageButton
    lateinit var navmypage: ImageButton
    lateinit var textview3: TextView
    lateinit var calendarView: CalendarView
    lateinit var checkBox1: CheckBox
    lateinit var checkBox2: CheckBox
    lateinit var checkBox3: CheckBox
    lateinit var checkBox4: CheckBox
    lateinit var checkBox5: CheckBox
    var mycoin = 0

    lateinit var dbManager: HabitActivity.DBManager
    lateinit var sqlitedb: SQLiteDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var catbutton: ImageButton = findViewById(R.id.catbutton)
        var navday: ImageButton = findViewById(R.id.navday)
        var navhome: ImageButton = findViewById(R.id.navhome)
        var navmypage: ImageButton = findViewById(R.id.navmypage)
        var calendarView: CalendarView = findViewById((R.id.calendarView))

        val listview: ListView
        val adapter: CustomChoiceListViewAdapter

//        //intent값 받아오기
//        var Intent = getIntent()
//        var editHabit: EditText = findViewById(R.id.editHabit)
//        textview3.setText(intent.getIntExtra("text", 0).toString())

        /*코인
        val pref = getSharedPreferences("user", 0)
        val editor = pref.edit()
        mycoin = (pref.getString("coin", "0"))!!.toInt()
        */

        //고양이 방 이동
        catbutton.setOnClickListener {
            val intent = Intent(this, CatRoom::class.java)
            startActivity(intent)
        }

        //네비게이션 이미지 버튼
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


        //오늘 날짜
        var cal: Calendar = Calendar.getInstance()
        var date = cal.time
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale("ko", "KR"))
        var dateText = dateFormat.format(date)

        //dbManager
        dbManager = HabitActivity.DBManager(this, "scheduleDB", null, 1)
        sqlitedb = dbManager.readableDatabase
        var cursor: Cursor

        cursor = sqlitedb.rawQuery(
            "SELECT * FROM scheduleDB WHERE date = '" + dateText + "' ORDER BY startTime",
            null
        )

        //캘린더 날짜 선택 시
        //일정 표시
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->

            //DayActivity로 이동
            val intent = Intent(this, DayActivity::class.java)
            startActivity(intent)
        }


        // Adapter 생성
        adapter = CustomChoiceListViewAdapter()

        // 리스트뷰 참조 및 Adapter달기
        listview = findViewById<View>(R.id.listview) as ListView
        listview.adapter = adapter

        while (cursor.moveToNext()) {
            var habit = cursor.getString(cursor.getColumnIndex("habit")).toString()
            var icon = cursor.getString(cursor.getColumnIndex("icon")).toString()

            var iconimg = R.drawable.catjelly
            when (icon) {
                "water" -> iconimg = R.drawable.water
                "bed" -> iconimg = R.drawable.bed
                "computer" -> iconimg = R.drawable.computer
                "exercise" -> iconimg = R.drawable.exercise
                "sleep" -> iconimg = R.drawable.moon
                "study" -> iconimg = R.drawable.study
                "reading" -> iconimg = R.drawable.reading
                "pill" -> iconimg = R.drawable.pill
                "meal" -> iconimg = R.drawable.meal
                "shopping" -> iconimg = R.drawable.shopping
                "bath" -> iconimg = R.drawable.bath
                "cleanup" -> iconimg = R.drawable.cleanup
            }

            adapter.addItem(
                ContextCompat.getDrawable(this, iconimg),
                habit.toString()
            )
//                Toast.makeText(this@MainActivity, "10코인 적립!", Toast.LENGTH_LONG).show()
//                val pref = getSharedPreferences("user", 0)
//                val editor = pref.edit()
//                mycoin = (pref.getString("coin", "500"))!!.toInt()
//                mycoin += 10
//                editor.putString("coin", mycoin.toString())
//                editor.apply()
        }
    }
//        // 첫 번째 아이템 추가.
//        adapter.addItem(
//            ContextCompat.getDrawable(this, iconimg),
//            editHabit.toString()
//        )
//        // 두 번째 아이템 추가.
//        adapter.addItem(
//            ContextCompat.getDrawable(this, iconimg),
//            editHabit.toString()
//        )
//        // 세 번째 아이템 추가.
//        adapter.addItem(
//            ContextCompat.getDrawable(this, iconimg),
//            editHabit.toString()
//        )
//        // 네 번째 아이템 추가.
//        adapter.addItem(
//            ContextCompat.getDrawable(this, iconimg),
//            editHabit.toString()
//        )
//        // 다섯 번째 아이템 추가.
//        adapter.addItem(
//            ContextCompat.getDrawable(this, iconimg),
//            editHabit.toString()
//        )
//    }

    //체크박스 체크 시

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            fun onCheckboxClicked(view: View) {
                if (view is CheckBox) {
                    val checked: Boolean = view.isChecked

                    val pref = getSharedPreferences("user", 0)
                    val editor = pref.edit()
                    mycoin = (pref.getString("coin", "500"))!!.toInt()

                    when (view.id) {
                        R.id.checkBox1 -> {
                            if (checked) {
                                Toast.makeText(this@MainActivity, "10코인 적립!", Toast.LENGTH_LONG)
                                    .show()
                                checkBox1.setChecked(false)
                                //코인 받아와서 +10한 후 반환
                                mycoin += 10
                                editor.putString("coin", mycoin.toString())
                                editor.apply()
                            }
                        }
                        R.id.checkBox2 -> {
                            if (checked) {
                                Toast.makeText(this@MainActivity, "10코인 적립!", Toast.LENGTH_LONG)
                                    .show()
                                checkBox2.setChecked(false)
                                //코인 받아와서 +10한 후 반환
                                mycoin += 10
                                editor.putString("coin", mycoin.toString())
                                editor.apply()
                            }
                        }
                        R.id.checkBox3 -> {
                            if (checked) {
                                Toast.makeText(this@MainActivity, "10코인 적립!", Toast.LENGTH_LONG)
                                    .show()
                                checkBox3.setChecked(false)
                                //코인 받아와서 +10한 후 반환
                                mycoin += 10
                                editor.putString("coin", mycoin.toString())
                                editor.apply()
                            }
                        }
                    }
                }
            }
        }
    }
}

