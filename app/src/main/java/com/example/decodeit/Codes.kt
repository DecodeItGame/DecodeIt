package com.example.decodeit

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.settings_button
import kotlinx.android.synthetic.main.codes.*

class Codes: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.codes)
        settings_button.setOnClickListener() {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }
        weekly_code_button.setOnClickListener() {
            val intent = Intent(this, WeeklyCode::class.java)
            startActivity(intent)
        }
        daily_code_button.setOnClickListener(){
            val intent = Intent(this, DailyCode::class.java)
            startActivity(intent)
        }
    }
}

