package com.jackandphantom.libtest.RxJava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jackandphantom.libtest.R
import com.jackandphantom.libtest.RxJava.flatmap.RecyclerAdapter
import com.jackandphantom.libtest.RxJava.flatmap.model.Comment
import com.jackandphantom.libtest.RxJava.flatmap.model.Post
import com.jackandphantom.libtest.RxJava.flatmap.service.Service
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Function
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.random.Random

class RxJavaActivity : AppCompatActivity() {

    lateinit var textView:TextView
    lateinit var editText: EditText
    lateinit var button: Button

    lateinit var recyclerview: RecyclerView

    lateinit var observable:Observable<String>
    lateinit var observer: Observer<String>
    private val recyclerAdapter: RecyclerAdapter = RecyclerAdapter()
    private val compositeDisposable = CompositeDisposable()

    companion object {
        const val TAG = "MY TAG RXJAVA"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java)
        recyclerview = findViewById(R.id.recycler_view)
        initRecyclerview()
        getPostObservable()
            .subscribeOn(Schedulers.io())
            .flatMap {
                return@flatMap getCommentObservable(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Post> {
                override fun onSubscribe(d: Disposable?) {
                    compositeDisposable.add(d)
                    Log.d(TAG, "onSubscribe: ")
                }

                override fun onNext(t: Post?) {
                    if (t != null) {
                        recyclerAdapter.updatePost(t)
                    }
                }

                override fun onError(e: Throwable?) {
                    Log.d(TAG, "onError: $e")
                }

                override fun onComplete() {
                    Log.d(TAG, "onComplete: ")
                }
            })


    }

    private fun getPostObservable():Observable<Post> {
        return Service.requestApi.getPost()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                recyclerAdapter.setPosts(it as MutableList<Post>)
                return@flatMap Observable.fromIterable(it).subscribeOn(Schedulers.io())
            }
    }

    private fun getCommentObservable(post: Post): Observable<Post> {
        return Service.requestApi
            .getComments(post.id)
            .map(Function {
                val delay = Random.nextLong(5) * 1000L
                Thread.sleep(delay)
                post.comments = it
                return@Function post
            })
            .subscribeOn(Schedulers.io())
    }

    private fun initRecyclerview() {
        recyclerview.adapter = recyclerAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

}