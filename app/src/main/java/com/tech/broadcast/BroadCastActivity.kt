package com.tech.broadcast

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fragment.R
import kotlinx.android.synthetic.main.activity_broad_cast.*

class BroadCastActivity : AppCompatActivity() {
    private val broadCastReceiver : MyBroadCastReceiver = MyBroadCastReceiver();
    private val customCastReceiver : CustomBroadCastReceiver = CustomBroadCastReceiver();
    private val orderCastReceiver : OrderBroadCast1Receiver = OrderBroadCast1Receiver();


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broad_cast)

        val intentFilter1 : IntentFilter = IntentFilter("com.tech.broadcast.CUSTOM_BROADCAST")
        intentFilter1.priority=1
        registerReceiver(orderCastReceiver,intentFilter1)


      /*  val intentFilter : IntentFilter = IntentFilter("com.tech.broadcast.CUSTOM_BROADCAST")
        registerReceiver(customCastReceiver,intentFilter)*/

        broadcastEx.setOnClickListener(View.OnClickListener {
            val intentFilter : IntentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
            registerReceiver(broadCastReceiver,intentFilter)
        })
        broadcastExStop.setOnClickListener(View.OnClickListener {
            unregisterReceiver(broadCastReceiver)
        })

        broadcastCu.setOnClickListener(View.OnClickListener {
            val intentFilter : IntentFilter = IntentFilter("com.tech.broadcast.CUSTOM_BROADCAST")
            registerReceiver(customCastReceiver,intentFilter)
        })
        broadcastECuStop.setOnClickListener(View.OnClickListener {
            unregisterReceiver(customCastReceiver)
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(orderCastReceiver)
    }

}