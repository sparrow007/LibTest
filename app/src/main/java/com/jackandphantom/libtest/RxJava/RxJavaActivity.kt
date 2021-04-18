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




    }



}