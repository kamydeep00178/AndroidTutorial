package com.tech

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fragment.R
import com.tech.alarmManager.AlarmManagerActivity
import com.tech.bound.BoundActivity
import com.tech.broadcast.BroadCastActivity
import com.tech.foregroundService.ForegroundActivity
import com.tech.fragment.FragmentActivity
import com.tech.jobIntent.JobIntentActivity
import com.tech.jobScheduler.JobSchedulerActivity
import com.tech.observerExample.Message
import com.tech.observerExample.MessagePublisher
import com.tech.observerExample.MessageSubscriberOne
import com.tech.observerExample.MessageSubscriberTwo
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
     //   setTheme(R.style.AppTheme)

        val s1 = MessageSubscriberOne()
        val s2 = MessageSubscriberTwo()

        val p = MessagePublisher()

        p.attach(s1)
        p.attach(s2)

        p.notifyUpdate(Message("First Message"))

        p.notifyUpdate(Message("Second Message"))

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
        alarm.setOnClickListener(View.OnClickListener {
            val intent : Intent = Intent(this, AlarmManagerActivity::class.java)
            startActivity(intent)
        })

//        motionLayout.setOnClickListener(View.OnClickListener {
//            val intent : Intent = Intent(this, MotionExample::class.java)
//            startActivity(intent)
//        })
    }
}