package com.jackandphantom.libtest.MVP.di

import com.jackandphantom.libtest.MVP.presenter.NewsDetailsPresenter
import com.jackandphantom.libtest.MVP.presenter.NewsListPresenter
import com.jackandphantom.libtest.MVP.presenter.impl.NewsDetailsImpl
import com.jackandphantom.libtest.MVP.presenter.impl.NewsListImpl
import dagger.Binds
import dagger.Module

@Module
abstract class FeatureModule {

    @Binds
    abstract fun provideNewsDetails(newsDetailsImpl: NewsDetailsImpl): NewsDetailsPresenter

    @Binds
    abstract fun provideNewsList(newsListImpl: NewsListImpl): NewsListPresenter
}