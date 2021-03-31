package com.jackandphantom.libtest.TestInterface

import android.util.Log

open class Base: First {
    override fun bind() {
        Log.e("MY TAG", "HELLO ")
    }

    override fun unbind() {
        Log.e("MY TAG", "UN BIND")
    }
}