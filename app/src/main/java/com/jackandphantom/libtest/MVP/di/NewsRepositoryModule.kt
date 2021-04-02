package com.jackandphantom.libtest.MVP.di

import com.jackandphantom.libtest.MVP.repository.NewsRepository
import com.jackandphantom.libtest.MVP.repository.repoimpl.MemoryRepository
import dagger.Binds
import dagger.Module


@Module
abstract class NewsRepositoryModule {

    @Binds
    abstract fun getNewsRepository(repository: MemoryRepository): NewsRepository
}