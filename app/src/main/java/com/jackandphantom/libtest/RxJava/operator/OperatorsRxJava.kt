package com.jackandphantom.libtest.RxJava.operator

import android.util.Log
import com.jackandphantom.libtest.RxJava.Defer.DeferRxJava
import com.jackandphantom.libtest.RxJava.RxJavaActivity
import com.jackandphantom.libtest.RxJava.model.Task
import com.jackandphantom.libtest.RxJava.utils.DataSource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit


private fun bufferOperate() {
    //Buffer operator
    Observable.just("a", "b", "c", "d", "e", "f", "g")
            .buffer(2)
            .subscribe(object: Observer<List<String>> {
                override fun onSubscribe(d: Disposable?) {
                    Log.d(RxJavaActivity.TAG, "onSubscribe: ")
                }

                override fun onNext(t: List<String>) {
                    Log.d(RxJavaActivity.TAG, "onNext: $t")
                }

                override fun onError(e: Throwable?) {
                    Log.d(RxJavaActivity.TAG, "onError: $e")
                }

                override fun onComplete() {
                    Log.d(RxJavaActivity.TAG, "onComplete: ")
                }

            })
}

private fun justObservable() {
    Observable.just(arrayOf("a", "b", "c", "d", "e", "f", "g", "h"), arrayOf("ankit", "supercool"))
            .subscribe(object: Observer<Array<String>> {
                override fun onSubscribe(d: Disposable?) {
                    Log.d(RxJavaActivity.TAG, "onSubscribe: ")
                }

                override fun onNext(t: Array<String>?) {
                    Log.d(RxJavaActivity.TAG, "onNext: ${Arrays.toString(t)}")
                }

                override fun onError(e: Throwable?) {
                    Log.d(RxJavaActivity.TAG, "onError: $e")
                }

                override fun onComplete() {
                    Log.d(RxJavaActivity.TAG, "onComplete: ")
                }

            })
}

private fun intervalObservable() {
    Observable.interval(1, TimeUnit.SECONDS)
            .subscribe(object : Observer<Long> {
                override fun onSubscribe(d: Disposable?) {
                    Log.d(RxJavaActivity.TAG, "onSubscribe: ")
                }

                override fun onNext(t: Long?) {
                    Log.d(RxJavaActivity.TAG, "onNext: $t")
                }

                override fun onError(e: Throwable?) {
                    Log.d(RxJavaActivity.TAG, "onError: $e")
                }

                override fun onComplete() {
                    Log.d(RxJavaActivity.TAG, "onComplete: ")
                }
            })
}

private fun deferObservable() {
    val defer = DeferRxJava()
    val observValue = defer.valueObservable()
    defer.value = "Ankit"
    observValue.subscribe(System.out::println)
}

private fun taskObservable() {
    val taskObservable = Observable.fromIterable(DataSource.createTaskList())
            .subscribeOn(Schedulers.io())
            .filter {

                Log.e(RxJavaActivity.TAG, "Subscribe On : "+ Thread.currentThread().name )
                Thread.sleep(500)
                it.isComplete
            }
            .observeOn(AndroidSchedulers.mainThread())

    taskObservable.subscribe(object : Observer<Task> {
        override fun onSubscribe(d: Disposable?) {
            Log.e(RxJavaActivity.TAG, "onSubscribe: $d")
        }

        override fun onNext(t: Task?) {
            Log.e(RxJavaActivity.TAG, "onNext: ${Thread.currentThread().name}")
            Log.e(RxJavaActivity.TAG, "onNext: $t ")
        }

        override fun onError(e: Throwable?) {
            Log.e(RxJavaActivity.TAG, "onError: ", e)
        }

        override fun onComplete() {
            Log.e(RxJavaActivity.TAG, "onComplete: is called")
        }

    })
}

private fun createObservable() {
   val observable = Observable.create<Int> {
        it.onNext(4)
        it.onComplete()

    }

    val observer = object : Observer<String> {
        override fun onSubscribe(d: Disposable?) {
        }

        override fun onNext(t: String?) {
            //textView.text = t
        }

        override fun onError(e: Throwable?) {

        }

        override fun onComplete() {

        }

    }
}