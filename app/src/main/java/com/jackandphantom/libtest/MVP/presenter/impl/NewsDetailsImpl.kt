package com.jackandphantom.libtest.MVP.presenter.impl

import android.util.Log
import com.jackandphantom.common.impl.mvp.BasePresenter
import com.jackandphantom.libtest.MVP.model.NewsDetails
import com.jackandphantom.libtest.MVP.presenter.NewsDetailsPresenter
import com.jackandphantom.libtest.MVP.repository.NewsRepository
import com.jackandphantom.libtest.MVP.ui.newsdetails.NewsDetailsView

class NewsDetailsImpl (val repository: NewsRepository) : BasePresenter<NewsDetails, NewsDetailsView>(),
 NewsDetailsPresenter{

    override fun displayNews(newsId: Long) {
        Log.i("MY TAG", "In NewsDetailPresenterImpl using Repository $repository")
        repository.byId(newsId)?.let { news ->
            view?.displayNews(news)
        }
    }

}