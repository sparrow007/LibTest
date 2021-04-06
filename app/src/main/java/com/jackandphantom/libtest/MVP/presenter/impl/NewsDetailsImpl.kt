package com.jackandphantom.libtest.MVP.presenter.impl

import android.util.Log
import com.jackandphantom.common.impl.mvp.BasePresenter
import com.jackandphantom.libtest.Extraa.MyClass
import com.jackandphantom.libtest.MVP.di.FeatureScope
import com.jackandphantom.libtest.MVP.model.NewsDetails
import com.jackandphantom.libtest.MVP.presenter.NewsDetailsPresenter
import com.jackandphantom.libtest.MVP.repository.NewsRepository
import com.jackandphantom.libtest.MVP.ui.newsdetails.NewsDetailsView
import javax.inject.Inject

@FeatureScope
class NewsDetailsImpl @Inject constructor (val repository: NewsRepository) : BasePresenter<NewsDetails, NewsDetailsView>(),
 NewsDetailsPresenter{

    override fun displayNews(newsId: Long) {
       // Log.e("MY TAG", "In NewsDetailPresenterImpl using Repository $repository")
        repository.byId(newsId)?.let { news ->
            view?.displayNews(news)
        }
    }

}