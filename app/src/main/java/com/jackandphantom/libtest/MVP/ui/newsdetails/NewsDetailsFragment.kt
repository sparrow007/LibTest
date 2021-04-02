package com.jackandphantom.libtest.MVP.ui.newsdetails

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jackandphantom.libtest.MVP.di.DaggerAppComponent
import com.jackandphantom.libtest.MVP.presenter.NewsDetailsPresenter
import com.jackandphantom.libtest.MVP.repository.entity.News
import com.jackandphantom.libtest.R
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [NewsDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsDetailsFragment : Fragment(), NewsDetailsView {

   @Inject
   lateinit var newsDetailsPresenter: NewsDetailsPresenter
    private lateinit var newsTitleTextView: TextView
    private lateinit var newsBodyTextView: TextView

    companion object {
        const val NEWS_ID = "news_id"

        fun create(bundle: Bundle?): NewsDetailsFragment = NewsDetailsFragment().apply {
            arguments = bundle
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerAppComponent.create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsDetailsPresenter.bind(this)
        newsTitleTextView = view.findViewById(R.id.news_detail_title)
        newsBodyTextView = view.findViewById(R.id.news_detail_body)
    }

    override fun onStart() {
        super.onStart()
        arguments?.getLong(NEWS_ID)?.let { newsId ->
            newsDetailsPresenter.displayNews(newsId)
        }
    }

    override fun displayNews(news: News) {
        newsTitleTextView.text = news.title
        newsBodyTextView.text = news.body
    }


    override fun onDestroy() {
        super.onDestroy()
        newsDetailsPresenter.unBind()
    }
}