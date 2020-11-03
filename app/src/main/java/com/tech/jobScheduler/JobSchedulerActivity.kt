package com.tech.jobScheduler

import android.R.attr.name
import android.R.id
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fragment.R
import kotlinx.android.synthetic.main.activity_job_scheduler.*


class JobSchedulerActivity : AppCompatActivity() {
    lateinit var jobInfo : JobInfo;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_scheduler)

        startSchedule.setOnClickListener(View.OnClickListener {



            val componentName = ComponentName(this, MyJobScheduler::class.java)
            /*= JobInfo.Builder(12, componentName)
                .setRequiresCharging(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .build()*/

            jobInfo = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                JobInfo.Builder(123, componentName)
                    .setMinimumLatency(5000)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    .setPersisted(true)
                    .build()
            } else {
                JobInfo.Builder(123, componentName)
                    .setPeriodic(5000)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    .setPersisted(true)
                    .build()
            }

            val jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val resultCode = jobScheduler.schedule(jobInfo)
            if (resultCode == JobScheduler.RESULT_SUCCESS) {
                Log.e("TAG", "Job scheduled!")
            } else {
                Log.e("TAG", "Job not scheduled")
            }


            /*val component = ComponentName(this, MyJobScheduler::class.java)
            val jobInfo: JobInfo = JobInfo.Builder(123, component)
                .setRequiresCharging(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                *//*.setPersisted(true)
                .setPeriodic(15 * 60 * 100)*//*
                .build()

            val jobScheduler: JobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val resultCode: Int = jobScheduler.schedule(jobInfo)
            if (resultCode == JobScheduler.RESULT_SUCCESS) {
                Log.e("TAG", "Success: ")
            } else {
                Log.e("TAG", "Not Success: ")

            }
*/
        })
        stopSchedule.setOnClickListener(View.OnClickListener {
            val jobScheduler: JobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            jobScheduler.cancel(123)
            Log.e("TAG", "Cancel: ")

        })
    }
}