package com.jackandphantom.libtest.RxJava.utils

import com.jackandphantom.libtest.RxJava.model.Task

object DataSource {

    fun createTaskList(): List<Task> {
        val list = ArrayList<Task>()
        list.add(Task("Great RxJava for data streams", false, 1))
        list.add(Task("Great RxJava for propagtion of change", false, 3))
        list.add(Task("Great RxJava comes with RxAndroid", true, 4))
        list.add(Task("Great RxJava added more threads features", true, 2))
        return list
    }
}