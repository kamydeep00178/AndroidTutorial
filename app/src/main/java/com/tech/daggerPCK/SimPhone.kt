package com.tech.daggerPCK

import android.util.Log
import javax.inject.Inject

class SimPhone @Inject constructor(private val serviceProvider: ServiceProvider) {
    init {
        Log.e("TAG", "Sim" )
    }

    fun getSim()
    {
        serviceProvider.getService()
        Log.e("TAG", "Sim avaiable" )
    }
}