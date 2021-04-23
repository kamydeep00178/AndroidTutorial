package com.tech.databinding

import android.view.View
import android.view.View.*
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object TextVisibleMoifiedBindingAdapter {
    @JvmStatic
    @BindingAdapter("visibleOrGone")
    fun View.setVisibleOrGone(show: Boolean) {
        visibility = if (show) VISIBLE else GONE
    }

    @BindingAdapter("visible")
    fun View.setVisible(show: Boolean) {
        visibility = if (show) VISIBLE else INVISIBLE
    }
}