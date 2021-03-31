package com.jackandphantom.common.impl

import com.jackandphantom.common.Model
import com.jackandphantom.common.Presenter
import com.jackandphantom.common.View

abstract class BasePresenter<M: Model, V: View<M>> : Presenter<M, V> {

    protected var view:V? = null

    override fun bind(v: V) {
        this.view = v
    }

    override fun unBind() {
        this.view = null
    }


}