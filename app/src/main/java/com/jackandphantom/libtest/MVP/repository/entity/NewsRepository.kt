package com.jackandphantom.libtest.MVP.repository.entity

interface NewsRepository {

    fun byId(id: Long): News

    fun getAllList(): List<News>

    fun insert(news: News)
}