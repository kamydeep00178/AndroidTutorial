package com.tech.intentSe

import android.app.IntentService
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyIntentService : IntentService("Intent Kamal Service") {


    override fun onCreate() {
        super.onCreate()
        Log.e("TAG", "onCreate: " )
    }

    override fun onHandleIntent(intent: Intent?) {
        Toast.makeText(applicationContext,"kamal",Toast.LENGTH_SHORT).show()
        Log.e("TAG", "onHandleIntent: "+intent?.getStringExtra("name")+"---"+Thread.currentThread().name)
        Thread.sleep(5000)

    }
}