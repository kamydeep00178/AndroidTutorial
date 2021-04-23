package com.tech.dagger.di.module

import com.tech.dagger.mypack.Prabal
import com.tech.dagger.mypack.PrabalGuruGram
import com.tech.dagger.mypack.PrabalMp
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class PrabalGurgramModule  {

    @Binds
    abstract fun providesPrabalMP(prabal: PrabalGuruGram) : Prabal

}