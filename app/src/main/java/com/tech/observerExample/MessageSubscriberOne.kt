package com.tech.observerExample

import android.util.Log

class MessageSubscriberOne : Observer {

    override fun update(m: Message?) {
        Log.e("TAG", "update: "+"MessageSubscriberOne"+m)
    }
}