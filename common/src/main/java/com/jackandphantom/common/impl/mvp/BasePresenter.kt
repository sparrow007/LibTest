package com.jackandphantom.common.impl.mvp

abstract class BasePresenter<M: Model, V: View<M>> : Presenter<M, V> {

    protected var view:V? = null

    override fun bind(v: V) {
        this.view = v
    }

    override fun unBind() {
        this.view = null
    }


}