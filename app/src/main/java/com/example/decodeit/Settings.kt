package com.example.decodeit

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.ShapeDrawable
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.decodeit.R

class Settings: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)

        val bitmap: Bitmap = Bitmap.createBitmap(700, 1000, Bitmap.Config.ARGB_8888)
        val canvas: Canvas = Canvas(bitmap)

        var shapeDrawable:ShapeDrawable

        var left = 0
        var right = 0
        var top = 0
        var bottom = 700
    }
}