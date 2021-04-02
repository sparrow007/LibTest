package com.jackandphantom.libtest.MVP

import android.app.Application
import com.jackandphantom.libtest.MVP.di.AppComponent
import com.jackandphantom.libtest.MVP.di.DaggerAppComponent

class InitApp : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    fun appComp() = appComponent
}