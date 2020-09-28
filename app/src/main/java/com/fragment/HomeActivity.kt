package com.fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fragment.bound.BoundActivity
import com.fragment.foregroundService.ForegroundActivity
import com.fragment.fragment.FragmentActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        fragment.setOnClickListener(View.OnClickListener {

            val intent : Intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        })

        foregroundService.setOnClickListener(View.OnClickListener {
            val intent : Intent = Intent(this,ForegroundActivity::class.java)
            startActivity(intent)
        })

        boundService.setOnClickListener(View.OnClickListener {
            val intent : Intent = Intent(this,BoundActivity::class.java)
            startActivity(intent)
        })
    }
}