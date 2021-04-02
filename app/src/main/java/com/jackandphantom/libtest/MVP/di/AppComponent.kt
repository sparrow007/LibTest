package com.jackandphantom.libtest.MVP.di

import com.jackandphantom.libtest.MVP.ui.newsdetails.NewsDetailsFragment
import com.jackandphantom.libtest.MVP.ui.newslist.NewsListFragment
import dagger.Component
import javax.inject.Singleton


@Component(modules = [AppModules::class, NewsRepositoryModule::class])
@Singleton
interface AppComponent {

    fun inject(newsListFragment: NewsListFragment)

    fun inject(newsDetailsFragment: NewsDetailsFragment)

}