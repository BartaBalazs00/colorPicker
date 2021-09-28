package com.example.szorgalmijava

import androidx.appcompat.app.AppCompatActivity
import android.widget.SeekBar
import android.widget.RelativeLayout
import android.widget.TextView
import android.os.Bundle
import android.view.View
import android.widget.SeekBar.OnSeekBarChangeListener

class MainActivity : AppCompatActivity() {
    private var SeekbarR = 0
    private var SeekBarG = 0
    private var SeekBarB = 0
    private val red_Bar: SeekBar? = null
    private val green_Bar: SeekBar? = null
    private val blue_Bar: SeekBar? = null
    private val layout: RelativeLayout? = null
    private val textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layout!!.findViewById<View>(R.id.layout)
        red_Bar!!.findViewById<View>(R.id.sb_red)
        green_Bar!!.findViewById<View>(R.id.sb_green)
        blue_Bar!!.findViewById<View>(R.id.sb_blue)
        textView!!.findViewById<View>(R.id.text_view)
        BackgorundColorUpdate()
        red_Bar.setOnSeekBarChangeListener(seekBarChangeListener)
        green_Bar.setOnSeekBarChangeListener(seekBarChangeListener)
        blue_Bar.setOnSeekBarChangeListener(seekBarChangeListener)
    }

    private val seekBarChangeListener: OnSeekBarChangeListener = object : OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
            BackgorundColorUpdate()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) {}
        override fun onStopTrackingTouch(seekBar: SeekBar) {}
    }

    private fun BackgorundColorUpdate() {
        SeekbarR = red_Bar!!.progress
        SeekBarG = green_Bar!!.progress
        SeekBarB = blue_Bar!!.progress
        layout!!.setBackgroundColor(
            -0x1000000
                    + SeekbarR * 0x10000 + SeekBarG * 0 * 100 + SeekBarB
        )
        textView!!.text = "($SeekbarR,$SeekBarG,$SeekBarB)"
    }
}