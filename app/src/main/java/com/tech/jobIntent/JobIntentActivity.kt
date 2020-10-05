package com.tech.jobIntent

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.JobIntentService.enqueueWork
import com.fragment.R
import kotlinx.android.synthetic.main.activity_job_intent.*


class JobIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_intent)
        start.setOnClickListener(View.OnClickListener {
            val mIntent = Intent(this, MyJobIntentService::class.java)
            mIntent.putExtra("maxCountValue", 10)
            MyJobIntentService.enqueueWork(this, mIntent)
        })

    }
}