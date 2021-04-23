package com.tech.activity

import android.os.Looper

class MyThread : Thread() {


    override fun run() {
        super.run()

        Looper.prepare()
        Looper.loop()

    }
}