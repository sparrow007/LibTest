package com.jackandphantom.libtest.MVP.ui.newslist

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jackandphantom.libtest.MVP.di.DaggerAppComponent
import com.jackandphantom.libtest.MVP.presenter.NewsListPresenter
import com.jackandphantom.libtest.MVP.repository.entity.News
import com.jackandphantom.libtest.R
import javax.inject.Inject

class NewsListFragment : Fragment(), NewsListView {

    @Inject
    lateinit var newsListPresenter: NewsListPresenter

    private lateinit var recyclerView: RecyclerView
    private  var newsList: List<News> = emptyList()
    private lateinit var adapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onAttach(context: Context) {
        DaggerAppComponent.create().inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsListPresenter.bind(this)
    }

    override fun onStart() {
        super.onStart()
        newsListPresenter.showNewsList()
    }

    override fun showsList(list: List<News>) {
        this.newsList = list
        adapter.notifyDataSetChanged()
    }

    private fun initRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = NewsListAdapter(newsList) {

        }

        recyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        newsListPresenter.unBind()
    }


}