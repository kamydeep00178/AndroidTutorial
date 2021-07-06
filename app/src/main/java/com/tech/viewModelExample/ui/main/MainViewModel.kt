package com.tech.viewModelExample.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private var count=0;

    var userData = User("kamal","16640")

   private var userLiveData= MutableLiveData<User>()

    init {
         userData = User("kamal","16640")
         userLiveData= MutableLiveData<User>()

        userLiveData.value=userData
    }



    // Transformation Live Data

    val liveData : LiveData<String> = Transformations.map(userLiveData)
    {
            it->"${userData.name} has this Roll No. ${userData.rollNo}"
    }



    var newUserLiveData= MutableLiveData<User>()

    val liveDataSwithMap : LiveData<User> = Transformations.switchMap(userLiveData,
        {
                it->getName(userLiveData.value?.name.toString())
        }
    )


    fun getName(name:String) : MutableLiveData<User>
    {
        var name1="name"

        newUserLiveData?.value?.name = name1
        return newUserLiveData
    }

   // val liveData : LiveData<String> = Transformations.map()
    fun getCount() : Int
    {
        return count
    }

    fun updateCount() : Int{
        return count++
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("TAG--------->", "onCleared: " )
    }


    override fun toString(): String {
        return super.toString()
    }

    override fun hashCode(): Int {
        Log.e("TAG", "hashCode: ", )
        return super.hashCode()
    }

}