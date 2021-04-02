package com.jackandphantom.libtest.MVP.ui.newslist

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jackandphantom.common.event.OnViewHolderItemSelect
import com.jackandphantom.libtest.MVP.repository.entity.News
import com.jackandphantom.libtest.R

class RecyclerViewHolder(
        private val itemView: View,
        listener: OnViewHolderItemSelect<News?>? = null) : RecyclerView.ViewHolder(itemView) {

    private var news: News? = null
    private val mTitleTextView: TextView = itemView.findViewById(R.id.news_title)
    private val mBodyTextView: TextView = itemView.findViewById(R.id.news_body)

    init {
        listener?.let { l ->
            itemView.setOnClickListener { l(news) }
        }
    }

    fun bind(model: News) {
        this.news = model
        model.run {
            mTitleTextView.text = title
            mBodyTextView.text = body
        }
    }

}