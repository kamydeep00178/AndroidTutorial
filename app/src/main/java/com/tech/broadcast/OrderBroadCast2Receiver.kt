package com.tech.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class OrderBroadCast2Receiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {

        Toast.makeText(p0, "CustomBroadCast2", Toast.LENGTH_SHORT).show()

        /*   var resultCode : Int = resultCode
           var resultData : String = resultData
           var bundle : Bundle = getResultExtras(true)
           var stringExtra : String? = bundle.getString("key")

           resultCode++
           stringExtra+="-->Order2"

           Toast.makeText(p0, "OrderBroadCast 2 Receiver\n result code "+resultCode+"\n"+stringExtra, Toast.LENGTH_SHORT).show()

           resultData = "OR2"
           bundle.putString("key",stringExtra)
           setResult(resultCode,resultData,bundle)

           abortBroadcast()*/
    }
}