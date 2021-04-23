package com.tech.dagger.mypack

import android.util.Log
import javax.inject.Inject

class Ashmeet @Inject constructor(var  prabal: Prabal, var atul: Atul) {





    fun provideInfo()
    {
        prabal.belong()
        Log.e("TAG", "provideInfo: ")
    }
}