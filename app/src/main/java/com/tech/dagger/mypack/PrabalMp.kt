package com.tech.dagger.mypack

import android.util.Log
import javax.inject.Inject

class PrabalMp @Inject constructor(var kilo:String): Prabal{
    override fun belong() {
        Log.e("TAG", "belong: MP "+"Kilo "+kilo )
    }
}