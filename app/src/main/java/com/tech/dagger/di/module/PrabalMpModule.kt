package com.tech.dagger.di.module

import com.tech.dagger.mypack.Prabal
import com.tech.dagger.mypack.PrabalMp
import dagger.Module
import dagger.Provides

@Module
class PrabalMpModule constructor(var kilo : String) {


    @Provides
    fun provideKilo() : String
    {
        return kilo
    }


    @Provides
    fun providesPrabalMP(prabal: PrabalMp) : Prabal
    {
        return  prabal
    }

}