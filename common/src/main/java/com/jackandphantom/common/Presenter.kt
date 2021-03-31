package com.jackandphantom.common

interface Presenter<M: Model, V : View<M>>  {

    fun bind(v:V)

    fun unBind()
}