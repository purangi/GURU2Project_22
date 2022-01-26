package com.example.guru2project_22

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Login : AppCompatActivity() {
    lateinit var editNickname: EditText
    lateinit var completeButton: Button

    lateinit var myHelper: myDBHelper
    lateinit var sqlDB: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editNickname = findViewById(R.id.editNickname)
        completeButton = findViewById(R.id.completeButton)

        myHelper = myDBHelper(this)

        completeButton.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            sqlDB.execSQL("INSERT INTO userTBL VALUES ( '"
                    + editNickname.text.toString() + "' );")
            sqlDB.close()

            //화면전환(메인 액티비티로)
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    inner class myDBHelper(context: Context) : SQLiteOpenHelper(context, "userDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL("CREATE TABLE userTBL (nickname CHAR(5) PRIMARY KEY);")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS userTBL")
            onCreate(db)
        }
    }

}