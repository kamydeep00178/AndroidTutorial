package com.tech.kotlinemy

import android.util.Log


fun String.capitalizeWords() : String = split(" ").map {
    Log.e("TAG", "capitalizeWords: "+ it.capitalize() )
    it.capitalize()

}.joinToString (" ")





val String.firstCharacter
    get() = this.take(1)

val Int.myPlus
    get() = this.plus(5)
