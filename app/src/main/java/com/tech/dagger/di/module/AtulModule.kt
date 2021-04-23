package com.tech.dagger.di.module

import com.tech.dagger.mypack.Atul
import dagger.Module
import dagger.Provides

@Module
class AtulModule {

    @Provides
    fun provideAtul() : Atul
    {
        return Atul()
    }
}