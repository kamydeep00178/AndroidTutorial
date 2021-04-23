package com.tech.broadcast

import android.content.Intent
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

        //



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

            // one way
            // register reciver
          /* val intentFilter : IntentFilter = IntentFilter("com.tech.broadcast.CUSTOM_BROADCAST")
            registerReceiver(customCastReceiver,intentFilter)*/



            // Send reciver

            val send : Intent=Intent("com.tech.broadcast.CUSTOM_BROADCAST")
        //    intent.setClass(this,CustomBroadCastReceiver::class.java)
            send.putExtra("com.tech.broadcast.EXTRA","kamal");
           // sendBroadcast(send)
            sendOrderedBroadcast(send,null)

        //



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