package com.jackandphantom.libtest.MVP.ui.newslist

import com.jackandphantom.common.View
import com.jackandphantom.libtest.MVP.model.NewsList
import com.jackandphantom.libtest.MVP.repository.entity.News

interface NewsListView : View<NewsList> {

    fun showsList(list: List<News>)
}