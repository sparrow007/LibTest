package com.jackandphantom.libtest.MVP.model

import com.jackandphantom.common.Model
import com.jackandphantom.libtest.MVP.repository.entity.News

data class NewsList (
    val list: List<News>
): Model