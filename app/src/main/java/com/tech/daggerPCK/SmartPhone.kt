package com.tech.daggerPCK

import android.util.Log
import javax.inject.Inject

class SmartPhone @Inject constructor(var battery: Battery,var simPhone: SimPhone,var memoryCard: MemoryCard) {

    init {
        Log.e("TAG", "Smart Phone Created" )
        battery.getPower()
        simPhone.getSim()
        memoryCard.getPower()
    }

    fun getPhoneAccording()
    {
        Log.e("TAG", "Get Phone According" )
    }
}