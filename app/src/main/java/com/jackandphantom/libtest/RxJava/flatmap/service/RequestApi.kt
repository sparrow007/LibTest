package com.jackandphantom.libtest.RxJava.flatmap.service

import com.jackandphantom.libtest.RxJava.flatmap.model.Comment
import com.jackandphantom.libtest.RxJava.flatmap.model.Post
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RequestApi {

    @GET("posts")
    fun getPost(): Observable<Post>

    @GET("posts/{id}/comments")
    fun getComments(@Path("id")id: Int):Observable<Comment>

}