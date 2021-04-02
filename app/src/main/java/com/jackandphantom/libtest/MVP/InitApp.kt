package com.jackandphantom.libtest.MVP

import android.app.Application
import com.jackandphantom.libtest.MVP.di.AppComponent
import com.jackandphantom.libtest.MVP.di.DaggerAppComponent
import com.jackandphantom.libtest.MVP.repository.repoimpl.MemoryRepository

class InitApp : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().repository(MemoryRepository())
    }

    fun appComp() = appComponent
}