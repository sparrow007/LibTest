package com.jackandphantom.libtest.RxJava.Defer

import io.reactivex.rxjava3.core.Observable

class DeferRxJava {

    var value: String = "cccc"

    fun valueObservable(): Observable<String> = Observable.defer { Observable.just(value) }

}