package com.tech.kotlinemy

sealed class MySealedClass {
    data class Manager(val name : String,val age: Int) : MySealedClass()

    class Dev(val name : String) : MySealedClass()
}