package com.jackandphantom.libtest.MVP.presenter.impl

import com.jackandphantom.common.impl.mvp.BasePresenter
import com.jackandphantom.libtest.MVP.model.NewsList
import com.jackandphantom.libtest.MVP.presenter.NewsListPresenter
import com.jackandphantom.libtest.MVP.repository.NewsRepository
import com.jackandphantom.libtest.MVP.ui.newslist.NewsListView

class NewsListImpl (val repository: NewsRepository): BasePresenter<NewsList, NewsListView>(),
    NewsListPresenter {

    override fun showNewsList() {
        TODO("Not yet implemented")
    }
}