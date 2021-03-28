package com.jackandphantom.libtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jackandphantom.libtest.network.RestApiService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiCall = RestApiService()

        //Go inside the method to see result
        apiCall.calledUser()
    }
}