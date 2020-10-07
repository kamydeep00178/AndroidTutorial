package com.tech.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class CustomBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        if("com.tech.broadcast.CUSTOM_BROADCAST".equals(p1?.action)) {
            val stringExtra =p1?.getStringExtra("com.tech.broadcast.EXTRA")
            Log.e("CustomBroadCast", "Connectivity Change")
            Toast.makeText(p0, "CustomBroadCast$stringExtra", Toast.LENGTH_SHORT).show()
        }
    }
}