package com.jackandphantom.libtest.MVP.di

import dagger.Component
import javax.inject.Singleton


@Component(modules = [AppModules::class, FeatureModule::class])
@Singleton
interface AppComponent {

    fun featureComponent(): FeatureComponent

}