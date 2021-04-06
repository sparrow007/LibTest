package com.jackandphantom.libtest.MVP.di

import com.jackandphantom.libtest.MVP.ui.newsdetails.NewsDetailsFragment
import com.jackandphantom.libtest.MVP.ui.newslist.NewsListFragment
import dagger.Component
import dagger.Subcomponent

@Subcomponent(modules = [FeatureModule::class])
@FeatureScope
interface FeatureComponent {

    fun inject(newsListFragment: NewsListFragment)

    fun inject(newsDetailsFragment: NewsDetailsFragment)


}