package com.tech.activity

import android.util.Log
import kotlin.math.log

class Person(val firstname: String,val lastName : String) {
    var name: String ?= null
    var contactNumber: String = "1234567890"
    var address: String = "xyz"

    fun displayInfo()  = Log.e("Data","\n firstname: $firstname\n \" +\n latName: $lastName\n \" +\n Name: $name\n " +
            "Contact Number: $contactNumber\n " +
            "Address: $address")

    override fun toString(): String {
        return "Person(firstname='$firstname', lastName='$lastName', name='$name', contactNumber='$contactNumber', address='$address')"
    }


    /*fun performLetOperation() {
       val person = Person().name.let {
            "The name of the Person is: ${it}"
       }
       Log.e("TAG", "performLetOperation: "+person )
       print(person)
   }*/
}
