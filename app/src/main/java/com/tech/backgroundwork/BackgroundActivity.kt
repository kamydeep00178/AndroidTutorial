package com.tech.backgroundwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fragment.R
import kotlinx.android.synthetic.main.activity_background.*

class BackgroundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background)
        coroutine.setOnClickListener({
            startActivity(Intent(this,CoroutineActivity::class.java))
        })

    }
}