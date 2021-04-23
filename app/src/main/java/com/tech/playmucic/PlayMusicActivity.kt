package com.tech.playmucic

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.core.content.ContextCompat
import com.fragment.R
import kotlinx.android.synthetic.main.activity_play_music.*

class PlayMusicActivity : AppCompatActivity() {

    private var mediaPlayer : MediaPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_music)

        mediaPlayer=MediaPlayer.create(this,R.raw.song)
        mediaPlayer?.setOnPreparedListener(
            {
                println("Ready To Go")
            }
        )


        playm.setOnClickListener({
            var intent = Intent(this,MusicService::class.java)
            startService(intent)
          //  ContextCompat.startForegroundService(this,intent)
        })


      /*  playm.setOnTouchListener { _, event ->
            handleTouch(event)
             true
        }*/




    }

    private fun handleTouch(event: MotionEvent?) {
        when(event?.action)
        {
             MotionEvent.ACTION_DOWN ->
             {
                println("down")
                 mediaPlayer?.start()
             }
            MotionEvent.ACTION_CANCEL,MotionEvent.ACTION_UP->
            {
                println("up or cancel")
                mediaPlayer?.pause()
                mediaPlayer?.seekTo(0)

            }
            else ->{
                println("Other")
            }
        }
    }
}