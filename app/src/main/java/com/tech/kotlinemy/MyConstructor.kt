package com.tech.kotlinemy

import android.util.Log

class MyConstructor {
  var a=10;
init {
 Log.e("TAG", "init ${a}" )
}

 constructor( a:Int ,b:Int) : this(a,b,7)
 {
    this.a=a
    var c=a+b
  Log.e("TAG", "Two : ${c}" )
 }
constructor(a : Int,b:Int,c :Int)
{
 var c=a+b+c
 Log.e("TAG", "Three : ${c}")
}

}