package com.tech.daggerPCK

import android.util.Log
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class MemoryCardModule(val memorySIze:Int) {

    @Provides
    fun providesMemoryCard() : MemoryCard
    {
        Log.e("TAG", "providesMemoryCard: $memorySIze" )
        return MemoryCard()
    }

}