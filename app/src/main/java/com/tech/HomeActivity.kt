package com.tech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fragment.R
import com.tech.bound.BoundActivity
import com.tech.broadcast.BroadCastActivity
import com.tech.broadcast.MyBroadCastReceiver
import com.tech.foregroundService.ForegroundActivity
import com.tech.fragment.FragmentActivity
import com.tech.jobIntent.JobIntentActivity
import com.tech.jobIntent.MyJobIntentService
import com.tech.jobScheduler.JobSchedulerActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        fragment.setOnClickListener(View.OnClickListener {

            val intent : Intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        })

        foregroundService.setOnClickListener(View.OnClickListener {
            val intent : Intent = Intent(this, ForegroundActivity::class.java)
            startActivity(intent)
        })

        boundService.setOnClickListener(View.OnClickListener {
            val intent : Intent = Intent(this, BoundActivity::class.java)
            startActivity(intent)
        })

        jobIntentService.setOnClickListener(View.OnClickListener {
            val intent : Intent = Intent(this, JobIntentActivity::class.java)
            startActivity(intent)
        })
        broadcast.setOnClickListener(View.OnClickListener {
            val intent : Intent = Intent(this, BroadCastActivity::class.java)
            startActivity(intent)
        })

        // minimum api level 21
        jonScheduler.setOnClickListener(
            View.OnClickListener {
                val intent : Intent = Intent(this, JobSchedulerActivity::class.java)
                startActivity(intent)
            }
        )
    }
}