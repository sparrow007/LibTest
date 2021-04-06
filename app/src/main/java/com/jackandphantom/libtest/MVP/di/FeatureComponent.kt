package com.jackandphantom.libtest.MVP.di

import com.jackandphantom.libtest.MVP.ui.newsdetails.NewsDetailsFragment
import com.jackandphantom.libtest.MVP.ui.newslist.NewsListFragment
import dagger.Component

@Component(
        modules = [FeatureModule::class],
        dependencies = [AppComponent::class]
)
interface FeatureComponent {

    fun inject(newsListFragment: NewsListFragment)

    fun inject(newsDetailsFragment: NewsDetailsFragment)


}