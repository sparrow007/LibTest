package com.jackandphantom.libtest.RxJava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.jackandphantom.libtest.R
import com.jackandphantom.libtest.RxJava.Defer.DeferRxJava
import com.jackandphantom.libtest.RxJava.model.Task
import com.jackandphantom.libtest.RxJava.utils.DataSource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.log

class RxJavaActivity : AppCompatActivity() {

    lateinit var textView:TextView
    lateinit var editText: EditText
    lateinit var button: Button

    lateinit var observable:Observable<String>
    lateinit var observer: Observer<String>

    companion object {
        const val TAG = "MY TAG RXJAVA"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java)

        textView = findViewById(R.id.text_view)
        editText = findViewById(R.id.edit_view)
        button = findViewById(R.id.button)
        //Buffer operator
        Observable.just("a", "b", "c", "d", "e", "f", "g")
                .buffer(2)
                .subscribe(object:Observer<List<String>>{
                    override fun onSubscribe(d: Disposable?) {
                        Log.d(TAG, "onSubscribe: ")
                    }

                    override fun onNext(t: List<String>) {
                        Log.d(TAG, "onNext: $t")
                    }

                    override fun onError(e: Throwable?) {
                        Log.d(TAG, "onError: $e")
                    }

                    override fun onComplete() {
                        Log.d(TAG, "onComplete: ")
                    }

                })


    }

    private fun justObservable() {
        Observable.just(arrayOf("a", "b", "c", "d", "e", "f", "g", "h"), arrayOf("ankit", "supercool"))
                .subscribe(object:Observer<Array<String>>{
                    override fun onSubscribe(d: Disposable?) {
                        Log.d(TAG, "onSubscribe: ")
                    }

                    override fun onNext(t: Array<String>?) {
                        Log.d(TAG, "onNext: ${Arrays.toString(t)}")
                    }

                    override fun onError(e: Throwable?) {
                        Log.d(TAG, "onError: $e")
                    }

                    override fun onComplete() {
                        Log.d(TAG, "onComplete: ")
                    }

                })
    }

    private fun intervalObservable() {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(object : Observer<Long> {
                    override fun onSubscribe(d: Disposable?) {
                        Log.d(TAG, "onSubscribe: ")
                    }

                    override fun onNext(t: Long?) {
                        Log.d(TAG, "onNext: $t")
                    }

                    override fun onError(e: Throwable?) {
                        Log.d(TAG, "onError: $e")
                    }

                    override fun onComplete() {
                        Log.d(TAG, "onComplete: ")
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

                    Log.e(TAG, "Subscribe On : "+ Thread.currentThread().name )
                    Thread.sleep(500)
                    it.isComplete
                }
                .observeOn(AndroidSchedulers.mainThread())

        taskObservable.subscribe(object : Observer<Task> {
            override fun onSubscribe(d: Disposable?) {
                Log.e(TAG, "onSubscribe: $d")
            }

            override fun onNext(t: Task?) {
                Log.e(TAG, "onNext: ${Thread.currentThread().name}")
                Log.e(TAG, "onNext: $t ")
            }

            override fun onError(e: Throwable?) {
                Log.e(TAG, "onError: ", e)
            }

            override fun onComplete() {
                Log.e(TAG, "onComplete: is called")
            }

        })
    }

    private fun createObservable() {
        observable = Observable.create {
            it.onNext(editText.text.toString())
            it.onComplete()

        }

        observer = object : Observer<String> {
            override fun onSubscribe(d: Disposable?) {
            }

            override fun onNext(t: String?) {
                textView.text = t
            }

            override fun onError(e: Throwable?) {

            }

            override fun onComplete() {

            }

        }
    }
}