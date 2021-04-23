package com.tech

import android.app.Application
import com.tech.daggerPCK.DaggerMyComponent
import com.tech.daggerPCK.MemoryCardModule
import com.tech.daggerPCK.MyComponent
import com.tech.daggerPCK.SmartPhone
import javax.inject.Inject

class MyApplication : Application() {

    @Inject
    lateinit var myComponent : MyComponent

    override fun onCreate() {
        myComponent=initDagger()

        super.onCreate()

    }

    fun initDagger() : MyComponent =
        DaggerMyComponent.builder()
            .memoryCardModule(MemoryCardModule(10))
            .build()

}