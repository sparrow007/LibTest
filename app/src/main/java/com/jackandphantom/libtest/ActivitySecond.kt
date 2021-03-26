package com.jackandphantom.libtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class ActivitySecond : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val button = findViewById<Button>(R.id.button_third)

        button.setOnClickListener {
            val intent = Intent(this@ActivitySecond, ActivityFirst::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()

        Log.e("MY TAG", "ON RESUME ")
    }

    override fun onPause() {
        super.onPause()

        Log.e("MY TAG", "ON Pause ")

    }
}