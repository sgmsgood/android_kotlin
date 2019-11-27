package com.elen.tiltsensor

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class TiltView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val greenPaint: Paint = Paint()
    private val blackPaint: Paint = Paint()

    init{
        greenPaint.color = Color.GREEN
        blackPaint.style = Paint.Style.STROKE
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawCircle(0f,0f,100f, blackPaint)
        canvas?.drawCircle(0f, 0f, 100f, greenPaint)
        drawCenterTheCross(canvas)
    }

    private fun drawCenterTheCross(canvas: Canvas?){
        canvas?.drawLine(-20f, 0f, 20f, 0f, blackPaint)
        canvas?.drawLine(0f, -20f, 0f, 20f, blackPaint)
    }
}