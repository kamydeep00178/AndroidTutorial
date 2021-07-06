package com.tech.kotlinemy

import android.util.Log

class MyConstructor (a: Int){
  var a=10;
init {
 Log.e("TAG", "init ${a}" )
}

 constructor( a:Int ,b:Int) : this(a) {
    this.a=a
    var c=a+b

  Log.e("TAG", "Two : ${c}" )

 }

  infix fun square(n : Int) : Int
  {
      val m = n*n
     return m
  }
//constructor(a : Int,b:Int,c :Int)
//{
// var c=a+b+c
// Log.e("TAG", "Three : ${c}")
//}

}