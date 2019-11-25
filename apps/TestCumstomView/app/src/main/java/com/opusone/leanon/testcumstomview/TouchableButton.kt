package com.opusone.leanon.testcumstomview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.Toast

class TouchableButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : Button(context, attrs, defStyleAttr) {
    private val TAG = "TouchableButton"

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d(TAG, "##shadow down")
                return true
            }

            MotionEvent.ACTION_UP -> {
                Log.d(TAG, "##shadow up")
                return true
            }
        }
        return super.onTouchEvent(event)
    }
}