package com.tech.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fragment.R
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {


    val TAG = "ThirdActivity"

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: ")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        finishAndRemoveTask()

        Log.e(TAG, "onCreate: " )
        singleTopSecond.setOnClickListener({
            val intent : Intent = Intent(this, SingleTOP::class.java)
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent)
        })

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
        Log.e(TAG, "Third onDestroy: " )
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