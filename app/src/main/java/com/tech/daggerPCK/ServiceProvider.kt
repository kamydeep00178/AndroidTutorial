package com.tech.daggerPCK

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor(){
    init {
        Log.e("TAG", "Service Provider" )
    }

    fun getService()
    {
        Log.e("TAG", "Service avaiable" )
    }
}