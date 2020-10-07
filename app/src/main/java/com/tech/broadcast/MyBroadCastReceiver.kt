package com.tech.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast

class MyBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
            if(Intent.ACTION_BOOT_COMPLETED.equals(p1?.action)) {
                Log.e("MyBroadCast", "Boot Complete")
                Toast.makeText(p0,"Boot Completed",Toast.LENGTH_SHORT).show()
            }
            if (ConnectivityManager.CONNECTIVITY_ACTION.equals(p1?.action))
            {
               var bol : Boolean? = p1?.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false)
                Log.e("MyBroadCast", "Connectivity Change")
                if (bol!!) {
                    Toast.makeText(p0, "Disconnected", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(p0, "Connected", Toast.LENGTH_SHORT).show()

                }
            }


    }
}