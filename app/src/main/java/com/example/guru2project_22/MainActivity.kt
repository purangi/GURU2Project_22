package com.example.guru2project_22

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.Toast.LENGTH_SHORT
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.utils.Utils.init

class MainActivity : AppCompatActivity() {
    private val DayActivity = DayActivity()
    private val MainActivity = MainActivity()
    lateinit var catbutton: ImageButton
    lateinit var navday: ImageButton
    lateinit var navhome: ImageButton
    lateinit var navmypage: ImageButton
    lateinit var btnIcon: ImageButton
    lateinit var textview3: TextView
    lateinit var calendarView: CalendarView
    lateinit var checkbox: CheckBox
    var iconName = ""
    var coin = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editHabit: EditText = findViewById(R.id.editHabit)
        var editText = editHabit.text.toString()


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
            iconName = btnIcon.toString()
            textview3.text = editHabit.text
            btnIcon.visibility = View.VISIBLE
            editHabit.visibility = View.VISIBLE
            checkbox.visibility = View.VISIBLE

        //DayActivity로 이동
            val intent = Intent(this, DayActivity::class.java)
            startActivity(intent)

        }

        //habit에서 완료를 누를 시 edit이 불러와짐
        //habit에서 완료를 누를 시 icon이 불려와짐
        //icon을 drawble 등으로 iconName에 나타냄
        //edittext를 textview3에 나타냄
        //체크박스...가 완료를 누를 때마다 하나씩 생기며 edit과 icon에 연결됨
        //캘린더 오늘날짜를 클릭 시 위의 3가지가 나옴
        //체크박스에 체크 시 코인을 불러와 10을 더한 다음 반환함


        fun onCheckboxClicked(view: View) {
            if (view is CheckBox) {
                val checked: Boolean = view.isChecked
                Toast.makeText(this@MainActivity, editText+" 완료! +10코인 적립!", Toast.LENGTH_LONG).show()

                when (view.id) {
                        R.drawable.water-> {
                            if(checked) {
                                Toast.makeText(this@MainActivity, editText+" 완료! +10코인 적립!", Toast.LENGTH_LONG).show()
                                coin+=10
                            }
                        }
                    R.drawable.bed-> {
                        if(checked) {
                            Toast.makeText(this@MainActivity, editText+" 완료! +10코인 적립!", Toast.LENGTH_LONG).show()
                            coin+=10
                        }
                    }
                    R.drawable.computer-> {
                        if(checked) {
                            Toast.makeText(this@MainActivity, editText+" 완료! +10코인 적립!", Toast.LENGTH_LONG).show()
                            coin+=10
                        }
                    }
                    R.drawable.exercise-> {
                        if(checked) {
                            Toast.makeText(this@MainActivity, editText+" 완료! +10코인 적립!", Toast.LENGTH_LONG).show()
                            coin+=10
                        }
                    }
                    R.drawable.exercise2-> {
                        if(checked) {
                            Toast.makeText(this@MainActivity, editText+" 완료! +10코인 적립!", Toast.LENGTH_LONG).show()
                            coin+=10
                        }
                    }
                    R.drawable.study-> {
                        if(checked) {
                            Toast.makeText(this@MainActivity, editText+" 완료! +10코인 적립!", Toast.LENGTH_LONG).show()
                            coin+=10
                        }
                    }
                    R.drawable.reading-> {
                        if(checked) {
                            Toast.makeText(this@MainActivity, editText+" 완료! +10코인 적립!", Toast.LENGTH_LONG).show()
                            coin+=10
                        }
                    }
                    R.drawable.pill-> {
                        if(checked) {
                            Toast.makeText(this@MainActivity, editText+" 완료! +10코인 적립!", Toast.LENGTH_LONG).show()
                            coin+=10
                        }
                    }
                    R.drawable.meal-> {
                        if(checked) {
                            Toast.makeText(this@MainActivity, editText+" 완료! +10코인 적립!", Toast.LENGTH_LONG).show()
                            coin+=10
                        }
                    }
                    R.drawable.shopping-> {
                        if(checked) {
                            Toast.makeText(this@MainActivity, editText+" 완료! +10코인 적립!", Toast.LENGTH_LONG).show()
                            coin+=10
                        }
                    }
                    R.drawable.bath-> {
                        if(checked) {
                            Toast.makeText(this@MainActivity, editText+" 완료! +10코인 적립!", Toast.LENGTH_LONG).show()
                            coin+=10
                        }
                    }
                    R.drawable.cleanup-> {
                        if(checked) {
                            Toast.makeText(this@MainActivity, editText+" 완료! +10코인 적립!", Toast.LENGTH_LONG).show()
                            coin+=10
                        }
                    }
                }
                }

            }

    }

}
/*
        //체크박스 클릭 시 +10 코인
        fun onCheckboxClicked(view: View) {
            if (view is CheckBox) {
                val checked: Boolean = view.isChecked

                when (view.id) {
                    R.id.checkbox_water-> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "물 한 잔 마시기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed-> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_computer-> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "일 하기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed-> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed-> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed-> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed-> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed-> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed-> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed-> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed-> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed-> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }

                }
            }
        }

        val sp = getSharedPreferences("Mycoin",MODE_PRIVATE)
        coin = sp.getInt("coin", 0)

    }

    init {
        coin += 10
        val sp = getSharedPreferences("Mycoin",MODE_PRIVATE)
        val editor = sp.edit()
        editor.putInt("coin", coin)
        editor.apply()
    }
}*/

