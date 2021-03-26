package com.jackandphantom.libtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityFirst : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val button = findViewById<Button>(R.id.button_first)

        button.setOnClickListener {
            val intent = Intent(this@ActivityFirst, ActivitySecond::class.java)
            startActivity(intent)
        }
    }
}