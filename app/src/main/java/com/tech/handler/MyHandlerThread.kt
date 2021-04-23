package com.tech.handler

import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.os.SystemClock
import android.util.Log


class MyHandlerThread : HandlerThread("My Handler") {

    val EXAMPLE_TASK =1

    private lateinit var handler : Handler


    override fun onLooperPrepared() {
        super.onLooperPrepared()
        Log.e("TAG", "onLooperPrepared: ", )
        handler = object : Handler() {
            override fun handleMessage(msg: Message) {
                when (msg.what) {
                    EXAMPLE_TASK -> {
                        Log.d(
                            "TAG",
                            "Example Task, arg1: " + msg.arg1.toString() + ", obj: " + msg.obj
                        + " --- "+Thread.currentThread().name)
                        var i = 0
                        while (i < 4) {
                            Log.d("TAG", "handleMessage: $i")
                            SystemClock.sleep(1000)
                            i++
                        }
                    }
                }
            }
        }
    }
    fun getHandler(): Handler? {
        return handler
    }
}