package com.jackandphantom.libtest.MVP.ui.newslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jackandphantom.common.event.OnViewHolderItemSelect
import com.jackandphantom.libtest.MVP.repository.entity.News
import com.jackandphantom.libtest.R

class NewsListAdapter (
        private val newsList: List<News>,
        private val listener : OnViewHolderItemSelect<News?>? = null) :
        RecyclerView.Adapter<RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_list_item_layout, parent, false)
        return RecyclerViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int {
       return newsList.size
    }
}