package com.tech.viewPager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.fragment.R
import kotlinx.android.synthetic.main.activity_my_view_pager2.*

class MyViewPager2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_view_pager2)
        view_pager2.adapter = ViewPagerAdapter()
        view_pager2.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        view_pager2.setPageTransformer(DepthPageTransformer())
        view_pager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                Log.e("TAG", "onPageScrolled: "+position+"positionOffset"
                        +positionOffset+"positionOffsetPixels"+positionOffsetPixels )
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("TAG","Selected_Page"+ "Pos" + position);

            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                Log.e("TAG","onPageScroll"+ "State" + state);

            }
        })

    }
}