package com.tech.alarmManager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.tech.foregroundService.MyService

class AlarmBroadCast : BroadcastReceiver()
{
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            val intent : Intent = Intent(context,MyService::class.java)
            context?.startService(intent);
        } else {
            Toast.makeText(context?.getApplicationContext(), "Alarm Manager just ran", Toast.LENGTH_LONG).show();
        }


    }

}