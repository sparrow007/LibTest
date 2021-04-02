package com.jackandphantom.libtest.MVP.model

import com.jackandphantom.common.impl.mvp.Model
import com.jackandphantom.libtest.MVP.repository.entity.News

data class NewsDetails(val news: News): Model
