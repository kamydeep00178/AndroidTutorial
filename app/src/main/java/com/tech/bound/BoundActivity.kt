package com.tech.bound

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import com.fragment.R
import kotlinx.android.synthetic.main.activity_bound.*
import kotlinx.android.synthetic.main.activity_home.*
import java.util.Observer


class BoundActivity : AppCompatActivity() ,View.OnClickListener {
    // Variable for storing instance of our service class
    var mService: BoundService? = null
    var TAG : String="BoundActivity"


    // Boolean to check if our activity is bound to service or not
    var mIsBound: Boolean? = null




    private fun getRandomNumberFromService() {
        mService?.randomNumberLiveData?.observe(this, androidx.lifecycle.Observer {
            resultTextView?.text="Random Number"+it
        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bound)

        startService?.setOnClickListener(this)
        stopService?.setOnClickListener(this)
        startActivity?.setOnClickListener(this)
    }
    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, iBinder: IBinder) {
            Log.e(TAG, "ServiceConnection: connected to service.")
            // We've bound to MyService, cast the IBinder and get MyBinder instance
            val binder = iBinder as BoundService.MyBinder
            mService = binder.service
            mIsBound = true
            getRandomNumberFromService() // return a random number from the service
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            Log.e(TAG, "ServiceConnection: disconnected from service.")
            mIsBound = false
        }
    }
    /**
     * Used to bind to our service class
     */
    private fun bindService() {
        Log.e(TAG, "bindService: ")
        Intent(this, BoundService::class.java).also { intent ->
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
        }

        var intent =Intent(this,BoundService::class.java)
        boundService
    }

    /**
     * Used to unbind and stop our service class
     */
    private fun unbindService() {
        Intent(this, BoundService::class.java).also { intent ->
            unbindService(serviceConnection)
        }
    }
    override
    fun onClick(v: View?) {
        when (v?.id) {
            R.id.startService -> {
                Log.e(TAG, "onClick: " )
                bindService()
            }
            R.id.stopService -> {
                if (mIsBound == true) {
                    unbindService()
                    mIsBound = false
                }
            }
            R.id.startActivity -> {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        // Unbinding to the service class
        unbindService()
    }
}