package com.tech.dagger.mypack

import android.util.Log
import javax.inject.Inject
import javax.inject.Named

class PrabalGuruGram @Inject constructor(@Named("kilo")var kilo:String, @Named("country")var Country:String,): Prabal{
    override fun belong() {
        Log.e("TAG", "belong: Gurugram "+" Kilometer= "+kilo +" Country "+Country)
    }
}