package com.jackandphantom.libtest.MVP.repository

import com.jackandphantom.libtest.MVP.repository.entity.News

interface NewsRepository {

    fun byId(id: Long): News?

    fun getAllList(): List<News>

    fun insert(news: News)
}