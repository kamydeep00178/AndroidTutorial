package com.tech.foregroundService

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.fragment.R
import kotlinx.android.synthetic.main.activity_foreground.*

class ForegroundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var TAG : String="ForegroundActivity"
        setContentView(R.layout.activity_foreground)

        starService.setOnClickListener(View.OnClickListener {
            Log.e(TAG, "start: Service")
          /*  MyService.startService(this, "Foreground Service is running...")*/

        var intent = Intent(this, MyService::class.java)
            intent.putExtra("inputExtra", "Hello Start")

       //     startService(intent)
            ContextCompat.startForegroundService(this, intent)


        })

        stoService.setOnClickListener(View.OnClickListener {
            Log.e(TAG, "stop: Service")
          /*  MyService.stopService(this)*/

              var intent  = Intent(this, MyService::class.java)
              stopService(intent)

        })
    }
}