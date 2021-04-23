package com.tech.LinkedListInterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fragment.R

class KotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        outerFunction("kamal")


    }
    fun outerFunction(nice: String) {
        val hello = "Hello, world"

        fun innerFunction(awesome: String) {
            Log.e("TAG", "innerFunction: "+awesome)

            // we can access arguments of outer function
            Log.e("TAG", "innerFunction: "+nice)


            // and we can also access variables declared in outer functions
            Log.e("TAG", "innerFunction: "+hello)

        }

        // invoking inner function
        innerFunction("This is awesome")
    }
}