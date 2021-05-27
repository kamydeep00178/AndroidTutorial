package com.tech.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fragment.R

class SingleInstance : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_instance)

        var data1 = intent.getStringExtra("k")
        var bundle  : Bundle? = intent.getExtras()
        var data = bundle?.getString("key")
        Log.e("TAG", "onCreate: "+data + data1 )
    }
}