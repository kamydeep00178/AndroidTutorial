package com.tech.observerExample

    interface Observer {
        abstract fun update(m: Message?)
    }