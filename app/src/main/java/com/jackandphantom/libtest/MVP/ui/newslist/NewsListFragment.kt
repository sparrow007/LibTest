package com.jackandphantom.libtest.MVP.ui.newslist

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jackandphantom.libtest.MVP.di.DaggerAppComponent
import com.jackandphantom.libtest.MVP.presenter.NewsListPresenter
import com.jackandphantom.libtest.R
import javax.inject.Inject

class NewsListFragment : Fragment() {

    @Inject
    lateinit var newsListPresenter: NewsListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onAttach(context: Context) {

        DaggerAppComponent.create().inject(this)
        super.onAttach(context)
    }
}