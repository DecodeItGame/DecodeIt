package com.example.decodeit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        settings_button.setOnClickListener(){
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }
        start_game.setOnClickListener(){
            val intent = Intent(this,Codes::class.java)
            startActivity(intent)
        }
    }
}