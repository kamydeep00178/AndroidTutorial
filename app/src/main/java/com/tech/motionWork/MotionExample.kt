/*
package com.tech.motionWork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bitvale.droidmotion.listener.BottomNavigationViewListener
import com.bitvale.droidmotion.listener.OnBackPressedListener
import com.fragment.R
import com.tech.common.replaceFragmentInActivity
import com.tech.motionWork.fragment.RecyclerFragment
import kotlinx.android.synthetic.main.activity_motion_example.*

class MotionExample : AppCompatActivity(),BottomNavigationViewListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_example)
        setupFragment(RecyclerFragment.newInstance())

    }

    private fun setupFragment(fragment: Fragment) {
        supportFragmentManager.findFragmentById(R.id.fragment_container)
            ?: fragment.let {
                replaceFragmentInActivity(it, R.id.fragment_container)
            }
    }

    override fun hideBottomNavigationView() {
        if (bottom_navigation.translationY == 0f)
            bottom_navigation.animate()
                .translationY(bottom_navigation.height.toFloat())
                .setDuration(250)
                .start()
    }

    override fun showBottomNavigationView() {
        if (bottom_navigation.translationY >= bottom_navigation.height.toFloat())
            bottom_navigation.animate()
                .translationY(0f)
                .setDuration(400)
                .start()
    }
    override fun onBackPressed() {
        val fragmentList = supportFragmentManager.fragments
        var proceedToSuper = true
        for (fragment in fragmentList) {
            if (fragment is OnBackPressedListener) {
                proceedToSuper = false
                (fragment as OnBackPressedListener).onBackPressed()
            }
        }
        if (proceedToSuper) super.onBackPressed()
    }
}*/
