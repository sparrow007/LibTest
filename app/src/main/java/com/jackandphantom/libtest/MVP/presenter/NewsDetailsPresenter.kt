package com.jackandphantom.libtest.MVP.presenter

import com.jackandphantom.common.Presenter
import com.jackandphantom.libtest.MVP.model.NewsDetails
import com.jackandphantom.libtest.MVP.repository.entity.News
import com.jackandphantom.libtest.MVP.ui.newsdetails.NewsDetailsView

interface NewsDetailsPresenter: Presenter<NewsDetails, NewsDetailsView> {

    fun displayNews()
}