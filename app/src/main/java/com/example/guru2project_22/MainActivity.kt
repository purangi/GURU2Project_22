package com.example.guru2project_22

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    private val DayActivity = DayActivity()
    private val MainActivity = MainActivity()
    lateinit var catbutton: ImageButton
    lateinit var navday: ImageButton
    lateinit var navhome: ImageButton
    lateinit var navmypage: ImageButton
    lateinit var textview3: TextView
    lateinit var calendarView: CalendarView
    lateinit var checkbox: CheckBox
    var mycoin = 0
    var iconName = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listview: ListView
        val adapter: CustomChoiceListViewAdapter
        var iconimg = intent.getIntExtra("icon", 0)

        //intent값 받아오기
        var Intent = getIntent()
        var editHabit: EditText = findViewById(R.id.editHabit)
        textview3.setText(intent.getIntExtra("text", 0).toString())

        //코인
        val pref = getSharedPreferences("user", 0)
        val editor = pref.edit()
        mycoin = (pref.getString("coin", "0"))!!.toInt()
        mycoin = findViewById(R.id.mycoin)

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


        //캘린더 날짜 선택 시
        //일정 표시
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            iconName = iconimg.toString()
            textview3.text = editHabit.text

            //DayActivity로 이동
            val intent = Intent(this, DayActivity::class.java)
            startActivity(intent)
        }


        // Adapter 생성
        adapter = CustomChoiceListViewAdapter()

        // 리스트뷰 참조 및 Adapter달기
        listview = findViewById<View>(R.id.listview) as ListView
        listview.adapter = adapter

        // 첫 번째 아이템 추가.
        adapter.addItem(
            ContextCompat.getDrawable(this, iconimg),
            editHabit.toString()
        )
        // 두 번째 아이템 추가.
        adapter.addItem(
            ContextCompat.getDrawable(this, iconimg),
            editHabit.toString()
        )
        // 세 번째 아이템 추가.
        adapter.addItem(
            ContextCompat.getDrawable(this, iconimg),
            editHabit.toString()
        )
        // 네 번째 아이템 추가.
        adapter.addItem(
            ContextCompat.getDrawable(this, iconimg),
            editHabit.toString()
        )
        // 다섯 번째 아이템 추가.
        adapter.addItem(
            ContextCompat.getDrawable(this, iconimg),
            editHabit.toString()
        )
    }

    //체크박스 체크 시

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkBox -> {
                //토스트 메시지 출력
                Toast.makeText(this@MainActivity, "10코인 적립!", Toast.LENGTH_LONG).show()
                    checkbox.setChecked(false)
                //코인 받아와서 +10한 후 반환
                val pref = getSharedPreferences("user", 0)
                val editor = pref.edit()
                mycoin = (pref.getString("coin", "100"))!!.toInt()
                mycoin += 10
                editor.putString("coin", mycoin.toString())
                editor.apply()
            }
            }
        }
    }
}
