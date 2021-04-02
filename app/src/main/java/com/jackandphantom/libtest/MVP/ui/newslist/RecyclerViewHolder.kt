package com.jackandphantom.libtest.MVP.ui.newslist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jackandphantom.common.event.OnViewHolderItemSelect
import com.jackandphantom.libtest.MVP.repository.entity.News

class RecyclerViewHolder(
        private val itemView: View,
        listener: OnViewHolderItemSelect<News?>? = null) : RecyclerView.ViewHolder(itemView) {

    private var news: News? = null

    init {
        listener?.let { l ->
            itemView.setOnClickListener { l(news) }
        }
    }

    fun bind(model: News) {
        this.news = model
    }

}