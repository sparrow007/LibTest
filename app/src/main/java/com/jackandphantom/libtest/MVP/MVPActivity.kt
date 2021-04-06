package com.jackandphantom.libtest.MVP

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jackandphantom.libtest.MVP.di.FeatureComponent
import com.jackandphantom.libtest.MVP.ui.newslist.NewsListFragment
import com.jackandphantom.libtest.R
import javax.inject.Provider

typealias FeatureComponentProvider = Provider<FeatureComponent>

class MVPActivity : AppCompatActivity(), FeatureComponentProvider {

    lateinit var featureComponent: FeatureComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_m_v_p)
        supportFragmentManager.beginTransaction().replace(R.id.anchor, NewsListFragment()).commit()

        featureComponent =  (applicationContext as InitApp).appComp().featureComponent()

    }

    override fun get(): FeatureComponent {
        return featureComponent
    }

}