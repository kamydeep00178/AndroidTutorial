package com.tech

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fragment.R
import com.tech.LinkedListInterview.KotlinActivity
import com.tech.activity.ActivityLifeCycle
import com.tech.alarmManager.AlarmManagerActivity
import com.tech.bound.BoundActivity
import com.tech.broadcast.BroadCastActivity
import com.tech.corountine.CoActivity
import com.tech.daggerPCK.DaggerActivity
import com.tech.foregroundService.ForegroundActivity
import com.tech.fragment.FragmentActivity
import com.tech.intentSe.MyIntentService
import com.tech.jobIntent.JobIntentActivity
import com.tech.jobScheduler.JobSchedulerActivity
import com.tech.observerExample.Message
import com.tech.observerExample.MessagePublisher
import com.tech.observerExample.MessageSubscriberOne
import com.tech.observerExample.MessageSubscriberTwo
import com.tech.playmucic.PlayMusicActivity
import com.tech.rx.MyRxActivity
import com.tech.telephoneyMan.TeleActivity
import com.tech.viewModelExample.MainActivity
import com.tech.viewPager2.MyViewPager2
import com.tech.workman.WorkActivity
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
        corountine.setOnClickListener(View.OnClickListener {
            val intent : Intent = Intent(this, CoActivity::class.java)
            startActivity(intent)
        })
        playMusic.setOnClickListener({
            val intent : Intent = Intent(this, PlayMusicActivity::class.java)
            startActivity(intent)
        })
        activity.setOnClickListener({
            val intent : Intent = Intent(this, ActivityLifeCycle::class.java)
            startActivity(intent)
        })
        viewModel.setOnClickListener({
            val intent : Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
        dataBinding.setOnClickListener({
            val intent : Intent = Intent(this, org.example.kotlin.databinding.MainActivity::class.java)
            //intent.
            startActivity(intent)

        })
        kotli.setOnClickListener({
            val intent : Intent = Intent(this, KotlinActivity::class.java)
            //intent.
            startActivity(intent)
        })
        work.setOnClickListener({
            val intent : Intent = Intent(this, WorkActivity::class.java)
            //intent.
            startActivity(intent)
        })
        dagger.setOnClickListener({
            val intent : Intent = Intent(this, DaggerActivity::class.java)
            //intent.
            startActivity(intent)
        })
        tele.setOnClickListener({
            val intent : Intent = Intent(this, TeleActivity::class.java)
            //intent.
            startActivity(intent)
        })
        rxJava.setOnClickListener({
            val intent : Intent = Intent(this, MyRxActivity::class.java)
            //intent.
            startActivity(intent)
        })
        viewPager.setOnClickListener({
            val intent : Intent = Intent(this, MyViewPager2::class.java)
            //intent.
            startActivity(intent)
        })
        intentService.setOnClickListener({
            val intent : Intent = Intent(this, MyIntentService::class.java)
            intent.putExtra("name","first")
            startService(intent)

            val intent1 : Intent = Intent(this, MyIntentService::class.java)
            intent1.putExtra("name","Second")
            startService(intent1)

            val intent2 : Intent = Intent(this, MyIntentService::class.java)
            intent2.putExtra("name","Third")
            startService(intent2)
        })



//        motionLayout.setOnClickListener(View.OnClickListener {
//            val intent : Intent = Intent(this, MotionExample::class.java)
//            startActivity(intent)
//        })
    }
}