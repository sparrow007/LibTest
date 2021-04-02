package com.jackandphantom.libtest.MVP

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jackandphantom.libtest.MVP.ui.newslist.NewsListFragment
import com.jackandphantom.libtest.R

class MVPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_m_v_p)
        supportFragmentManager.beginTransaction().replace(R.id.anchor, NewsListFragment()).commit()
    }
}