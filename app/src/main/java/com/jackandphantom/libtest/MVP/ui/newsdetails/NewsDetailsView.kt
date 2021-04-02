package com.jackandphantom.libtest.MVP.ui.newsdetails

import com.jackandphantom.common.impl.mvp.View
import com.jackandphantom.libtest.MVP.model.NewsDetails
import com.jackandphantom.libtest.MVP.repository.entity.News

interface NewsDetailsView : View<NewsDetails> {

    fun displayNews(news: News)
}