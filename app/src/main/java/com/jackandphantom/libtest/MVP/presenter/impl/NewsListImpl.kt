package com.jackandphantom.libtest.MVP.presenter.impl

import android.util.Log
import com.jackandphantom.common.impl.mvp.BasePresenter
import com.jackandphantom.libtest.MVP.model.NewsList
import com.jackandphantom.libtest.MVP.presenter.NewsListPresenter
import com.jackandphantom.libtest.MVP.repository.NewsRepository
import com.jackandphantom.libtest.MVP.ui.newslist.NewsListView
import javax.inject.Inject

class NewsListImpl  @Inject constructor(val repository: NewsRepository): BasePresenter<NewsList, NewsListView>(),
    NewsListPresenter {

    override fun showNewsList() {
       // Log.e("MY TAG", "In NewsListPresenterImpl using Repository $repository")
        val newsList = repository.getAllList()
        view?.showsList(newsList)
    }
}