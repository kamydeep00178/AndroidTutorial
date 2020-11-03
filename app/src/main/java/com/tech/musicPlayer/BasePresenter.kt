package com.tech.musicPlayer

abstract class BasePresenter<V : BaseView> constructor(private val view: V)