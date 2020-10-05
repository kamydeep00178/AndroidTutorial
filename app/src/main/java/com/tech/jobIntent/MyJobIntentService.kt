package com.tech.jobIntent

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class MyJobIntentService : JobIntentService() {

    private val TAG = "MyJobIntentService"

    companion object {
        private val JOB_ID = 2
        fun enqueueWork(context: Context?, intent: Intent?) {
            if (context != null) {
                enqueueWork(context, MyJobIntentService::class.java, JOB_ID, intent!!)
            }
        }
    }

    override fun onHandleWork(intent: Intent) {

        /**
         * Write code here.. Perform Long operation here such as Download/Upload of file, Sync Some data
         * The system or framework is already holding a wake lock for us at this point
         */
        /**
         * Write code here.. Perform Long operation here such as Download/Upload of file, Sync Some data
         * The system or framework is already holding a wake lock for us at this point
         */
        val maxCount = intent.getIntExtra("maxCountValue", -1)
        /**
         * Suppose we want to print 1 to 1000 number with one-second interval, Each task will take time 1 sec, So here now sleeping thread for one second.
         */
        /**
         * Suppose we want to print 1 to 1000 number with one-second interval, Each task will take time 1 sec, So here now sleeping thread for one second.
         */
        for (i in 0 until maxCount) {
            Log.e(TAG, "onHandleWork: The number is: $i")
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()

        Log.e(TAG, "On Destroy")

    }
}