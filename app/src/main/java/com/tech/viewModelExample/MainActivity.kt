package com.tech.viewModelExample

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fragment.R
import com.tech.viewModelExample.ui.main.MainFragment
import com.tech.viewModelExample.ui.main.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var viewModel1: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.liveData.observe(this, Observer {
            Log.e("TAG", "onCreate: "+it.toString())

        })


        Log.e("TAG", "hasCode: "+viewModel.hashCode() )
        viewModel1 = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel1.liveData.observe(this, Observer {
            Log.e("TAG", "onCreate: "+it.toString())

        })
        Log.e("TAG", " 2nd hasCode: "+viewModel.hashCode() )



    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return super.onRetainCustomNonConfigurationInstance()
    }

}