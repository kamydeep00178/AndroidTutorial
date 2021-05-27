package com.tech.viewModelExample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fragment.R
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private lateinit var customClass: CustomClass


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        if (savedInstanceState != null) {
            customClass = savedInstanceState.getParcelable<CustomClass>("myKey")!!
            Log.e(
                "TAG",
                "Restore Data:" + customClass.data + "HashCode = " + customClass.hashCode()
            )
        } else {
            customClass = CustomClass()
            Log.e("TAG", "Create Object :" + customClass.hashCode())
        }

        upDateButton.setOnClickListener({

            customClass.data = customClass.data + " efgh"

        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putParcelable("myKey", customClass);

    }

}