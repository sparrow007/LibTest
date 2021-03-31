package com.jackandphantom.libtest.MVP.presenter

import com.jackandphantom.common.Presenter
import com.jackandphantom.libtest.MVP.model.NewsList
import com.jackandphantom.libtest.MVP.ui.newslist.NewsListView

interface NewsListPresenter: Presenter<NewsList, NewsListView> {

    fun showNewsList()
}