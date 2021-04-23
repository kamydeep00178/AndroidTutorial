package com.tech.dagger.di.componenet

import com.tech.activity.ActivityLifeCycle
import com.tech.dagger.di.module.AtulModule
import com.tech.dagger.di.module.PrabalGurgramModule
import com.tech.dagger.di.module.PrabalMpModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(modules = [AtulModule::class, PrabalGurgramModule::class])
interface AshComponent {

   /* fun getAshmeet() : Ashmeet*/

    fun inject(activity : ActivityLifeCycle)

    @Component.Builder
    interface Builder
    {
        @BindsInstance
        fun kiloMeter(@Named("kilo") kilo : String) : Builder

        @BindsInstance
        fun country(@Named("country") country : String) : Builder

        fun build() : AshComponent


    }
}