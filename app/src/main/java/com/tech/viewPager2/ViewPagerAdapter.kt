package com.tech.viewPager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fragment.R
import kotlinx.android.synthetic.main.item_page.view.*

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.PagerVH>() {

    //array of colors to change the background color of screen
    private val colors = intArrayOf(
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple
    )

    class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
        PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))


    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {
        if(position == 0){
            tvTitle.text = "ViewPager2"
            tvAbout.text = "In this application we will learn about ViewPager2"
            ivImage.setImageResource(R.drawable.background_music)
            container.setBackgroundResource(colors[position])
        }
        if(position == 1) {
            tvTitle.text = "ViewPager2"
            tvAbout.text = "In this application we will learn about ViewPager2"
            ivImage.setImageResource(R.drawable.background_music)
            container.setBackgroundResource(colors[position])
        }
        if(position == 2) {
            tvTitle.text = "ViewPager2"
            tvAbout.text = "In this application we will learn about ViewPager2"
            ivImage.setImageResource(R.drawable.background_music)
            container.setBackgroundResource(colors[position])
        }
        if(position == 3) {
            tvTitle.text = "ViewPager2"
            tvAbout.text = "In this application we will learn about ViewPager2"
            ivImage.setImageResource(R.drawable.background_music)
            container.setBackgroundResource(colors[position])
        }
    }

    override fun getItemCount(): Int {
       return Int.MAX_VALUE
    }

}