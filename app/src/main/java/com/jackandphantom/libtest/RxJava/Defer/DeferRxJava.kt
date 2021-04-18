package com.jackandphantom.libtest.RxJava.Defer

import io.reactivex.rxjava3.core.Observable

class DeferRxJava {

    lateinit var value: String

    fun valueObservable(): Observable<String> {
        return Observable.just(value)
    }

}