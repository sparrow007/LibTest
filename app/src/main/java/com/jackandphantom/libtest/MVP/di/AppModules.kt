package com.jackandphantom.libtest.MVP.di

import com.jackandphantom.libtest.MVP.presenter.NewsDetailsPresenter
import com.jackandphantom.libtest.MVP.presenter.NewsListPresenter
import com.jackandphantom.libtest.MVP.presenter.impl.NewsDetailsImpl
import com.jackandphantom.libtest.MVP.presenter.impl.NewsListImpl
import com.jackandphantom.libtest.MVP.repository.NewsRepository
import com.jackandphantom.libtest.MVP.repository.repoimpl.MemoryRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
 abstract class AppModules {

    @Binds
    abstract fun provideNewsDetails(newsDetailsImpl: NewsDetailsImpl): NewsDetailsPresenter

    @Binds
    abstract fun provideNewsList(newsListImpl: NewsListImpl): NewsListPresenter

}