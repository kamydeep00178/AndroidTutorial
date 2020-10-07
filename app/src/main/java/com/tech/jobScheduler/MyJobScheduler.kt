package com.tech.jobScheduler

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class MyJobScheduler : JobService() {

    private val TAG: String = MyJobScheduler::class.java.getSimpleName()
    var isWorking = false
    var jobCancelled = false

    override fun onStartJob(p0: JobParameters?): Boolean {
        Log.e("JOb Service", "onStartJob: ")
        isWorking = true;
        if (p0 != null) {
            startWorkOnNewThread(p0)
        }; // Services do NOT run on a separate thread

        return isWorking
    }

    private fun startWorkOnNewThread(jobParameters: JobParameters) {
        Thread { doWork(jobParameters) }.start()
    }

    private fun doWork(jobParameters: JobParameters) {
        // 10 seconds of working (1000*10ms)
        for (i in 0..999) {
            // If the job has been cancelled, stop working; the job will be rescheduled.
            if (jobCancelled) return
            try {
                Thread.sleep(10)
            } catch (e: Exception) {
            }
        }
        Log.e(TAG, "Job finished!")
        isWorking = false
        val needsReschedule = false
        jobFinished(jobParameters, needsReschedule)
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.e("JOb Service", "job canceled: ")
        jobCancelled = true
        val needsReschedule = isWorking
        jobFinished(p0, needsReschedule)
        return needsReschedule
    }
}