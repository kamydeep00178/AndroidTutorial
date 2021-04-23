package com.tech.corountine

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class UserDataManager2 {

    suspend fun getTotalUserCount() : Int
    {
        var count =0
        lateinit var deffered :  Deferred<Int>
        coroutineScope {
            launch(Dispatchers.IO) {
                delay(1000)
                count=50
                Log.e("TAG", "IO: $"+Thread.currentThread().name)
            }

             deffered= async(Dispatchers.IO) {
                delay(3000)
                return@async 70

            }

        }


        return count + deffered.await()
    }
}