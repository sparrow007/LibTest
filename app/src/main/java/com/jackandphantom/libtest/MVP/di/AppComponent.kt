package com.jackandphantom.libtest.MVP.di

import com.jackandphantom.libtest.MVP.repository.NewsRepository
import com.jackandphantom.libtest.MVP.repository.repoimpl.MemoryRepository
import com.jackandphantom.libtest.MVP.ui.newsdetails.NewsDetailsFragment
import com.jackandphantom.libtest.MVP.ui.newslist.NewsListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Component(modules = [AppModules::class])
@Singleton
interface AppComponent {

    fun repository(): NewsRepository

}