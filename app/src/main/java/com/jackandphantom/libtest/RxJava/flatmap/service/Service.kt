package com.jackandphantom.libtest.RxJava.flatmap.service

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Service {

   private const val BASE_URL = "https://jsonplaceholder.typicode.com"

    val requestApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RequestApi::class.java)

}