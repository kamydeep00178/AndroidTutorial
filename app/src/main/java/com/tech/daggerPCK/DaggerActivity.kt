package com.tech.daggerPCK

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fragment.R
import com.tech.MyApplication
import javax.inject.Inject

class DaggerActivity : AppCompatActivity() {

    @Inject  lateinit var smartPhone: SmartPhone
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)


        (application as MyApplication).myComponent.inject(this)
        smartPhone.getPhoneAccording()

        /*DaggerMyComponent.create().inject(this)
        smartPhone.getPhoneAccording()*/

//        val smartPhone = SmartPhone(Battery(),
//            SimPhone(ServiceProvider()),MemoryCard())
//            .getPhoneAccording()



    }
}