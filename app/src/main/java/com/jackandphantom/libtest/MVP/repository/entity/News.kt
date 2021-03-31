package com.jackandphantom.libtest.MVP.repository.entity

import com.jackandphantom.common.Model

data class News (
    val id : Long,
    val title: String,
    val body: String
): Model
