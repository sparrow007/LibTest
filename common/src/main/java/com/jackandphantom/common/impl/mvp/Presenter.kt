package com.jackandphantom.common.impl.mvp

interface Presenter<M: Model, V : View<M>>  {

    fun bind(v:V)

    fun unBind()
}