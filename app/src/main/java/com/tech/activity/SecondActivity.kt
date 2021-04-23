package com.tech.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fragment.R
import kotlinx.android.synthetic.main.activity_life_cycle.*
import kotlinx.android.synthetic.main.activity_second2.*

class SecondActivity : AppCompatActivity() {

    val TAG = "SecondActivity"

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)
        Log.e(TAG, "onCreate: " )
        buttonThird.setOnClickListener({
            val intent : Intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        })
        // Now on Destroy Method is called
      //  finish()
    }
    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: " )
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: " )
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: " )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: " )
    }


    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onRestart: " )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e(TAG, "onSaveInstanceState: " )
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e(TAG, "onRestoreInstanceState: " )
    }


    override fun onBackPressed() {
        super.onBackPressed()
        Log.e(TAG, "onBackPressed: " )
    }


}