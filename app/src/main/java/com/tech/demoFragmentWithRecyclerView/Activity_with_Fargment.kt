package com.tech.demoFragmentWithRecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fragment.R

class Activity_with_Fargment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_fargment)
        if(savedInstanceState== null)
        {
            supportFragmentManager.beginTransaction()
                .add(R.id.container,OrderFragment.newInstance())
                .addToBackStack("True")
                .commit()
        }

    }
}