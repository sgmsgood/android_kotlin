package com.opusone.leanon.testcumstomview

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Button

class TouchableButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : Button(context, attrs, defStyleAttr) {
    private val TAG = "TouchableButton"

    var onShadowListener: OnShadowListener? = null
    var onButtonClickListener: OnPerformListener? = null

    private var touchStayed = false

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val rect = Rect(0, 0, right - left, bottom - top)

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                touchStayed = false
                showShadow(false)

            }

            MotionEvent.ACTION_UP -> {
                if(touchStayed){
                    setPerformListener()
                }
                touchStayed = false
                showShadow(true)
            }

            MotionEvent.ACTION_MOVE -> {
                touchStayed = rect.contains(event.x.toInt(), event.y.toInt())
                if(!touchStayed) {
                    showShadow(true)
                }
            }

            MotionEvent.ACTION_CANCEL -> {
                touchStayed = false
            }
        }
        return super.onTouchEvent(event)
    }

    private fun showShadow(isShadow: Boolean){
        onShadowListener?.let {
            it(isShadow)
        }
    }

    private fun setPerformListener(){
        onButtonClickListener?.let{
            it(this)
        }
    }
}

typealias OnShadowListener = (Boolean) -> Unit
typealias OnPerformListener = (view: View) -> Unit

