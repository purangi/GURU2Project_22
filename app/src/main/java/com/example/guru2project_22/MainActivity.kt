package com.example.guru2project_22

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.utils.Utils.init

class MainActivity : AppCompatActivity() {

//    private val MyPage = MyPage()
    private val DayActivity = DayActivity()
    private val MainActivity = MainActivity()
    lateinit var catbutton: ImageButton
    lateinit var navday: ImageButton
    lateinit var navhome: ImageButton
    lateinit var navmypage: ImageButton
    var coin = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        //체크박스 클릭 시 +10 코인
        fun onCheckboxClicked(view: View) {
            if (view is CheckBox) {
                val checked: Boolean = view.isChecked

                when (view.id) {
                    R.id.checkbox_water -> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "물 한 잔 마시기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed -> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_computer -> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "일 하기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed -> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed -> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed -> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed -> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed -> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed -> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed -> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed -> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }
                    R.id.checkbox_bed -> {
                        if (checked) {
                            Toast.makeText(this@MainActivity, "낮잠 자기 완료!", Toast.LENGTH_LONG)
                            coin += 10
                        } else {
                        }
                    }

                }
            }
        }

        val sp = getSharedPreferences("Mycoin", MODE_PRIVATE)
        coin = sp.getInt("coin", 0)

    }

    init {
        coin += 10
        val sp = getSharedPreferences("Mycoin", MODE_PRIVATE)
        val editor = sp.edit()
        editor.putInt("coin", coin)
        editor.apply()
    }
}
