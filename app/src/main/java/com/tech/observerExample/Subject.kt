package com.tech.observerExample

interface Subject {
    fun attach(o: Observer?)
    fun detach(o: Observer?)
    fun notifyUpdate(m: Message?)
}