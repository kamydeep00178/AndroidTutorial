package com.tech.customView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fragment.R

class CustomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)

        var list : List<String> = emptyList()
        set(value)
        {

        }

        findViewById<IndicatorView>(R.id.indicator1).setOnClickListener {
            findViewById<IndicatorView>(R.id.indicator1).colors = listOf(Color.BLACK, Color.RED)
        }

        findViewById<IndicatorView>(R.id.indicator1).colors = listOf(Color.BLUE)
        findViewById<IndicatorView>(R.id.indicator2).colors = listOf(Color.BLACK, Color.RED)
        findViewById<IndicatorView>(R.id.indicator3).colors = listOf(Color.WHITE, Color.RED, Color.GREEN)
        findViewById<IndicatorView>(R.id.indicator4).colors = listOf(Color.BLUE, Color.BLACK, Color.RED, Color.GREEN)
        findViewById<IndicatorView>(R.id.indicator5).colors = listOf(Color.WHITE, Color.BLUE, Color.BLACK, Color.RED, Color.GREEN)
    }
}