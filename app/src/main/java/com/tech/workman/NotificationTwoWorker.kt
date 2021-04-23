package com.tech.workman

import android.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters


class NotificationTwoWorker(context: Context, workerParams: WorkerParameters) : Worker(
    context,
    workerParams
) {
    private val WORK_RESULT = "work_result"
    override fun doWork(): Result {
        Log.e("TAG", "doWork: "+ Thread.currentThread().name)
        val taskData: Data = inputData
        val taskDataString: String? = taskData.getString("message_status")
        showNotification("WorkManager", taskDataString ?: "Message has been Sent")
        val outputData: Data = Data.Builder().putString(WORK_RESULT, "Jobs Finished").build()
        return Result.success(outputData)
    }
    private fun showNotification(task: String, desc: String) {
        val manager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "task_channel"
        val channelName = "task_name"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, channelId)
            .setContentTitle(task)
            .setContentText(desc)
            .setSmallIcon(R.mipmap.sym_def_app_icon)
        manager.notify(1, builder.build())

    }
}
