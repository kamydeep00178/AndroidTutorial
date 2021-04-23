package com.tech.kotlinemy

import android.util.Log
import kotlin.math.log
import kotlin.properties.Delegates

//One Way
const val APIKEY = "123224kkam-18920-1AAAAA"
class MyClass {

  lateinit var name : String

  var test by Delegates.notNull<String>()

 /* private val myObject : MyObject by lazy() {
    Log.e("TAG", ": Created")
    MyObject
  }*/

 /* companion object
  {
    var age = "aa"

  }*/
  fun setName() {
    test= "kamal"
    name= "kamal"
    name = "deep"
    print(name)
  }

  //var age = "kamal"
 // val aa = "aaaa"

//  //  val exp = getName()
//    //2nd way
//    companion object {
//      const val NAMECONST1 = "kamal"
//        val age = myAge()
//        fun myAge() : String
//        {
//            return "20"
//        }
//
//    }

   /* fun getName() : String
    {
        return "kkkkkkk"
    }*/



}