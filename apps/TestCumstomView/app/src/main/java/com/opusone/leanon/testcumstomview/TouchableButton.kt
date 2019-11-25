package com.opusone.leanon.testcumstomview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.my_custom_view.view.*

class TouchableButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : Button(context, attrs, defStyleAttr) {
    private val TAG = "TouchableButton"

    var OnOoButtonClickListener: OnOoButtonClickListener? =  null



    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d(TAG, "##shadow down")
                performClick()
                return true
            }

            MotionEvent.ACTION_UP -> {
                Log.d(TAG, "##shadow up")
                return true
            }
        }
        return super.onTouchEvent(event)
    }

    override fun performClick(): Boolean {
        super.performClick()
        OnOoButtonClickListener?.let {
            it(this)
        }
        return true
    }
}
