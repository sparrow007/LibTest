package com.jackandphantom.libtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button_second)

        button.setOnClickListener {
            //Go to first
            val intent = Intent(this@MainActivity, ActivityFirst::class.java)
            startActivity(intent)
        }
    }
}