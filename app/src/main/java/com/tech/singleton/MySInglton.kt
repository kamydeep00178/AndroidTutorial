package com.tech.singleton

import android.content.Context
import android.util.Log

object MySInglton {

    fun getInstance(context: Context)
    {
        Log.e("TAG", "getInstance: "+context.toString())
    }
    fun getData() : String
    {
        return  "kamal"
    }

}