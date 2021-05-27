package com.tech.backgroundwork

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {


    var data = MutableLiveData<String>()

    //View Model Scope
    fun getData()
    {
        viewModelScope.launch(Dispatchers.Default) {
            data.postValue("Kamal - "+Thread.currentThread().name)
        }
    }

    //Live Data Scope

    var myData : LiveData<String> = liveData(Dispatchers.IO) {
        emit("My live Data - "+Thread.currentThread().name)
    }



}