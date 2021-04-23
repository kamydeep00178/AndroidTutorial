package com.tech.playmucic

import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.fragment.R
import com.tech.foregroundService.ForegroundActivity

class MusicService : Service() {


    private var mediaPlayer : MediaPlayer?=null
    private lateinit var remoteView: RemoteViews
    val CHANNEL_ID = "ForegroundServiceChannel"
    var TAG : String="MyService"

    private lateinit var intentCancel: PendingIntent
    private lateinit var intentPlay: PendingIntent


    val BROADCAST_ID_MUSIC = 201
    val NOTIFICATION_CANCEL = "notification.CANCEL"
    val NOTIFICATION_PLAY="notification.PLAY"

    private var isPlaying: Boolean = false

    lateinit var notificationManager : NotificationManager;


    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    private val receiver =  object : BroadcastReceiver()
    {
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.action) {
                NOTIFICATION_CANCEL -> {
                    pause()
                    stopForeground(true)
                }
                NOTIFICATION_PLAY -> {
                    if (isPlaying) {
                        pause()
                        Log.e(TAG, "onReceive: "+isPlaying)
                    } else {
                        play()
                        Log.e(TAG, "onReceive: "+isPlaying)
                    }
                    updateNotification()
                }
            }
        }

    }

    private fun play() {
        isPlaying=true
        mediaPlayer?.start()
    }

    private fun pause() {
        isPlaying=false
        mediaPlayer?.pause()
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("TAG", "onCreate: ")

        createNotificationChannel()
        initRemoteView()
        registerReceiver()



    }

    private fun registerReceiver() {
        val intentFilter = IntentFilter()
        intentFilter.addAction(NOTIFICATION_PLAY)
        intentFilter.addAction(NOTIFICATION_CANCEL)
        registerReceiver(receiver, intentFilter)
    }

    private fun initRemoteView() {
        remoteView = RemoteViews(packageName, R.layout.notification_song)

        // For Cancel Intent
        intentCancel = PendingIntent.getBroadcast(
            this, BROADCAST_ID_MUSIC,
            Intent(NOTIFICATION_CANCEL).setPackage(packageName),
            PendingIntent.FLAG_CANCEL_CURRENT
        )

        //For play Intent

        intentPlay = PendingIntent.getBroadcast(
            this, BROADCAST_ID_MUSIC,
            Intent(NOTIFICATION_PLAY).setPackage(packageName),
            PendingIntent.FLAG_CANCEL_CURRENT
        )


    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("TAG", "onStartCommand: ", )
        val notificationIntent = Intent(this, ForegroundActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0, notificationIntent, 0
        )

     /*   remoteView.setImageViewResource(
            R.id.img_play,
            if (isPlaying) R.drawable.ic_pause else R.drawable.ic_play
        )
        remoteView.setOnClickPendingIntent(R.id.img_cancel, intentCancel)
        remoteView.setOnClickPendingIntent(R.id.img_play, intentPlay)


        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Foreground Service")
            .setContentText("input")
            .setSmallIcon(android.R.mipmap.sym_def_app_icon)
            //  .setContentIntent(pendingIntent)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setOnlyAlertOnce(true)
            .setCustomContentView(remoteView)
            .setCustomBigContentView(remoteView)
            .build()*/

     //  startForeground(1,createNotification());




        mediaPlayer=MediaPlayer.create(this, R.raw.song)
        mediaPlayer?.setVolume(100F,100F)
        mediaPlayer?.setOnPreparedListener(
            {
                println("Ready To Go")
            }
        )
        mediaPlayer?.start()
        return startId
    }


    override fun onDestroy() {
        Log.e("TAG", "onDestroy: " )

        mediaPlayer?.stop()
        mediaPlayer?.release()
    }
    fun createNotificationChannel()
    {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O)
        {
            Log.e(TAG, "start Channel: Service")
            var notificationChannel : NotificationChannel = NotificationChannel(
                CHANNEL_ID,
                "CHANNEL",
                NotificationManager.IMPORTANCE_DEFAULT
            )
             notificationManager  = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

    fun createNotification() : Notification
    {
        remoteView.setImageViewResource(
            R.id.img_play,
            if (isPlaying) R.drawable.ic_pause else R.drawable.ic_play
        )
        remoteView.setOnClickPendingIntent(R.id.img_cancel, intentCancel)
        remoteView.setOnClickPendingIntent(R.id.img_play, intentPlay)


        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Foreground Service")
            .setContentText("input")
            .setSmallIcon(android.R.mipmap.sym_def_app_icon)
            //  .setContentIntent(pendingIntent)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setOnlyAlertOnce(true)
            .setCustomContentView(remoteView)
            .setCustomBigContentView(remoteView)
            .build()

        return notification
    }
    fun updateNotification()
    {
            notificationManager.notify(1,createNotification())
    }
}