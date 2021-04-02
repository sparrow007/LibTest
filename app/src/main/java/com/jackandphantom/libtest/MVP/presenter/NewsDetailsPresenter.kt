package com.jackandphantom.libtest.MVP.presenter

import com.jackandphantom.common.impl.mvp.Presenter
import com.jackandphantom.libtest.MVP.model.NewsDetails
import com.jackandphantom.libtest.MVP.ui.newsdetails.NewsDetailsView

interface NewsDetailsPresenter: Presenter<NewsDetails, NewsDetailsView> {

    fun displayNews(newsId: Long)
}