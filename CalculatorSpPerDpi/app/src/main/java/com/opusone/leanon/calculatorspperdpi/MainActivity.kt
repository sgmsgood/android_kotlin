package com.opusone.leanon.calculatorspperdpi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("#getScreenInches(): ${getScreenInches()}")

        val inch = getScreenInches() + 0.5

        val textSize = (40 * resources.displayMetrics.density)



        println("textSize: $textSize")
    }

    fun getScreenInches(): Double{
        val dm: DisplayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        println(windowManager.defaultDisplay.getMetrics(dm))

        val width = dm.widthPixels
        val height = dm.heightPixels

        val wi = width.toDouble() / dm.xdpi
        val hi = height.toDouble() / dm.ydpi

        val x = Math.pow(wi, 2.0)
        val y = Math.pow(hi, 2.0)

        println("wi: $wi, y: $hi")
        println("x: $x, y: $y")

        val screenInches = Math.sqrt(x + y)

        return screenInches
    }

    private fun println(message: String){
        Log.d(TAG, "##$message")
    }
}
