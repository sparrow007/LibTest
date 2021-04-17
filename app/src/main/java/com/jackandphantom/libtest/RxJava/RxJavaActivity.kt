package com.jackandphantom.libtest.RxJava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.jackandphantom.libtest.R
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class RxJavaActivity : AppCompatActivity() {

    lateinit var textView:TextView
    lateinit var editText: EditText
    lateinit var button: Button

    lateinit var observable:Observable<String>
    lateinit var observer: Observer<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java)

        textView = findViewById(R.id.text_view)
        editText = findViewById(R.id.edit_view)
        button = findViewById(R.id.button)

        createObservable()

        button.setOnClickListener {
            observable.subscribe(observer)
        }


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