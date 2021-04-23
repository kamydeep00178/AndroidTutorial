package com.tech.daggerPCK

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
abstract class BatteryModule {

    @Binds
   abstract fun providesBattery( batterCompany: BatterCompany) : Battery


}