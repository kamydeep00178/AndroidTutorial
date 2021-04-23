package com.tech.workman

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import com.fragment.R
import kotlinx.android.synthetic.main.activity_work.*
import java.util.concurrent.TimeUnit


class WorkActivity : AppCompatActivity() {
    val MESSAGE_STATUS = "message_status"
    private val WORK_RESULT = "work_result"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)
        val mWorkManager = WorkManager.getInstance()



        val data : Data = Data.Builder()
            .putString(MESSAGE_STATUS,"Hello Kamal")
            .build()

        val constraints= Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val mRequest = OneTimeWorkRequest.Builder(NotificationWorker::class.java)
            .setConstraints(constraints)
            .setInputData(data)
            .build()


        val peridRequest = PeriodicWorkRequest.Builder(NotificationWorker::class.java,16,TimeUnit.MINUTES)
            .build()

        val peridRequest1 = PeriodicWorkRequest.Builder(NotificationWorker::class.java,40,TimeUnit.MINUTES)
            .build()


        button.setOnClickListener({
            mWorkManager.enqueue(peridRequest)
        })


        mWorkManager.getWorkInfoByIdLiveData(mRequest.id)
            .observe(this, object : Observer<WorkInfo?> {
                override fun onChanged(@Nullable workInfo: WorkInfo?) {
                    if (workInfo != null) {
                        val state = workInfo.state
                        if (workInfo.state.isFinished) {
                            textView.append(
                                """$state""".trimIndent()+workInfo.outputData.getString(WORK_RESULT)
                            )
                        }
                    }
                }
            })
    }

}