package com.jackandphantom.libtest.MVP.di

import com.jackandphantom.libtest.MVP.presenter.impl.NewsDetailsImpl
import com.jackandphantom.libtest.MVP.presenter.impl.NewsListImpl
import com.jackandphantom.libtest.MVP.repository.NewsRepository
import com.jackandphantom.libtest.MVP.repository.repoimpl.MemoryRepository
import dagger.Module
import dagger.Provides


@Module
class AppModules {

    @Provides
    fun getNewsDetails(newsRepository: NewsRepository) = NewsDetailsImpl(newsRepository)

    @Provides
    fun getNewsList(newsRepository: NewsRepository) = NewsListImpl(newsRepository)

    @Provides
    fun getNewsRepository() : NewsRepository = MemoryRepository()

}