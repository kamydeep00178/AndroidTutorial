package com.tech.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class OrderBroadCast1Receiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
                /*   var resultCode : Int = resultCode
                   var resultData : String = resultData
                   var bundle : Bundle = getResultExtras(true)
                   var stringExtra : String? = bundle.getString("key")

                   resultCode++
                   stringExtra+="-->Order1"*/
        Toast.makeText(p0, "CustomBroadCast1", Toast.LENGTH_SHORT).show()
                 //Toast.makeText(p0, "OrderBroadCast 1 Receiver\n result code "+resultCode+"\n"+stringExtra, Toast.LENGTH_SHORT).show()

               /*   resultData = "OR1"
                 bundle.putString("key",stringExtra)
                 setResult(resultCode,resultData,bundle)*/
    }
}