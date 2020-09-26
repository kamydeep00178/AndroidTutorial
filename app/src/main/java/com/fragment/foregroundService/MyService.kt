package com.fragment.foregroundService

import android.R
import android.annotation.SuppressLint
import android.app.*
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat


class MyService : Service() {

    val CHANNEL_ID = "ForegroundServiceChannel"
    var TAG : String="MyService"

    override fun onCreate() {
        Log.e(TAG, "start: on Create")
        super.onCreate()
    }

    @SuppressLint("WrongConstant")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(TAG, "start Command: Service")
        var input : String = intent!!.getStringExtra("inputExtra")
        createNotificationChannel()
        val notificationIntent = Intent(this, ForegroundActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0, notificationIntent, 0
        )

        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Foreground Service")
            .setContentText(input)
            .setSmallIcon(R.mipmap.sym_def_app_icon)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification);

        Log.e(TAG, " Running: Service")



            stopForeground(1)

        return START_NOT_STICKY

    }

    override fun onBind(intent: Intent): IBinder? {
        return  null;
    }

    override fun onDestroy() {
        Log.e(TAG, " Destroy: Service")
        super.onDestroy()
    }




    fun createNotificationChannel()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            Log.e(TAG, "start Channel: Service")
            var notificationChannel : NotificationChannel = NotificationChannel(
                CHANNEL_ID,
                "CHANNEL",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            var notificationManager : NotificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }


}
