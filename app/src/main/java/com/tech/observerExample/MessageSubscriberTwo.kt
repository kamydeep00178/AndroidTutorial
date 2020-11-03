package com.tech.observerExample

import android.util.Log

class MessageSubscriberTwo : Observer {
    override fun update(m: Message?) {
        Log.e("TAG", "update: "+"MessageSubscriberTwo"+m)
    }
}