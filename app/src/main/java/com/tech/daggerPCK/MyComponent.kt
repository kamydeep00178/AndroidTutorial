package com.tech.daggerPCK

import dagger.Component
import dagger.Module

@Component(modules = [MemoryCardModule::class,BatteryModule::class])
interface MyComponent{

    fun inject(daggerActivity: DaggerActivity)

}
