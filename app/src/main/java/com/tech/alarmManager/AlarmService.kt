package com.tech.alarmManager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.JobIntentService
import com.tech.broadcast.MyBroadCastReceiver


class AlarmService : JobIntentService() {

    override fun onHandleWork(intent: Intent) {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val alarmIntent = Intent(this, MyBroadCastReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0)
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, 0, 10000, pendingIntent)
    }

}