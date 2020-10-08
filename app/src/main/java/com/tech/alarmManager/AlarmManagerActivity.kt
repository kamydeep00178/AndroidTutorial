package com.tech.alarmManager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.fragment.R
import kotlinx.android.synthetic.main.activity_alarm_manager.*

class AlarmManagerActivity : AppCompatActivity() {
     lateinit var alarmManager : AlarmManager;
    lateinit var pendingIntent : PendingIntent ;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_manager)
        alarmManager=getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent : Intent = Intent(this,AlarmBroadCast::class.java)
        pendingIntent = PendingIntent.getBroadcast(this,0,intent,0)

        btnStartAlarm.setOnClickListener(View.OnClickListener {
            startAlarm()
        })

        btnCancelAlarm.setOnClickListener(View.OnClickListener {
            alarmManager.cancel(pendingIntent);
            Toast.makeText(getApplicationContext(), "Alarm Cancelled", Toast.LENGTH_LONG).show();
        })
    }

    private fun startAlarm() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            Log.e("TAG", "startAlarm: if")
            alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, 0, pendingIntent);
        }
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Log.e("TAG", "startAlarm: else if")
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, 0, pendingIntent);
        } else {
            Log.e("TAG", "startAlarm: else")

            alarmManager.set(AlarmManager.RTC_WAKEUP, 0, pendingIntent);
        }
    }
}