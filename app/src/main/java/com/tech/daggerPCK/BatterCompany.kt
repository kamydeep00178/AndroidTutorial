package com.tech.daggerPCK

import android.util.Log
import javax.inject.Inject

class BatterCompany @Inject constructor():Battery {
    override fun getPower() {
        Log.e("TAG", "Battery Created" )
    }

}