package com.tech.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fragment.R
import kotlinx.android.synthetic.main.activity_life_cycle.*
import kotlinx.android.synthetic.main.activity_sinngle_t_o_p.*

class SingleTOP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sinngle_t_o_p)
        Log.e("SingleTop", "onCreate: ")
        singleTopSecond.setOnClickListener({
            val intent : Intent = Intent(this, SingleTOP::class.java)
            startActivity(intent)
        })
        third.setOnClickListener({
            val intent : Intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        })
    }

    override fun onDestroy() {
        Log.e("TAG", "Single Top onDestroy: ", )
        super.onDestroy()
    }
}