package com.opusone.leanon.testcumstomview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.my_custom_view.view.*


class OoFlatButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val TAG = "MyView"

    private val MARGIN_LEFT_RATIO = 0.02
    private val MARGIN_TOP_RATIO = 0.04
    private val MARGIN_BOTTOM_RATIO = 0.2
    private val MARGIN_RIGHT_RATIO = 0.02

    private var pixelWidth = 0
    private var pixelHeight = 0

    private var textString = ""
    private var floatFontSize = 0.0f
    private var bgButton = 0

    private var isShadow = true
    private var isKeepShadowMargin = true

    var onFlatButtonClickListener: ((view: View) -> Unit)? = null

    private var layoutView: View? = null

//    private var touchableButton: TouchableButton? = null

    init {
        layoutView = LayoutInflater.from(context).inflate(R.layout.my_custom_view, this, true)

        attrs?.let {
            val attrsArray = context.obtainStyledAttributes(attrs, R.styleable.OoFlatButton, 0, 0)

            parseAttrs(attrsArray)

            var touchableButton = TouchableButton(context, attrs, defStyleAttr)

            touchableButton?.setOnClickListener{
                showShadow(isShadow)
            }
        }
    }

    private fun parseAttrs(attrsArray: TypedArray) {
        textString = attrsArray.getString(R.styleable.OoFlatButton_Text) ?: ""

        floatFontSize =
            attrsArray.getDimensionPixelSize(R.styleable.OoFlatButton_FontSize, 0).toFloat()

        bgButton =
            attrsArray.getResourceId(R.styleable.OoFlatButton_BackGround, R.drawable.basic_button)

        isShadow = attrsArray.getBoolean(R.styleable.OoFlatButton_isShadow, true)

        isKeepShadowMargin =
            attrsArray.getBoolean(R.styleable.OoFlatButton_isKeepshadowMargin, true)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        pixelWidth = MeasureSpec.getSize(widthMeasureSpec)
        pixelHeight = MeasureSpec.getSize(heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Log.d(TAG, "##changed: $changed")

        renderShadow()
        renderShadowMargin()
        setButtonAttr()
    }


    private fun renderShadow() {
        shadow.visibility = if (isShadow) View.VISIBLE else View.GONE
    }

    private fun renderShadowMargin() {
        if (isKeepShadowMargin) {
            setMargin(pixelWidth, pixelHeight)

        } else {
            setMargin(0, 0)
        }
    }

    private fun setButtonAttr() {
        testButton.text = textString
        testButton.textSize = floatFontSize
        testButton.setBackgroundResource(bgButton)
    }

    private fun convertPxToDp(px: Double): Int {
        val displayMetrics = context.resources.displayMetrics
        return (px / displayMetrics.density).toInt()
    }

    private fun convertDpToPx(dp: Int): Int {
        val displayMetrics = context.resources.displayMetrics
        return (dp * displayMetrics.density).toInt()
    }

    private fun setMargin(pixelWidth: Int, pixelHeight: Int) {
        val marginPxLeft = convertDpToPx(convertPxToDp((pixelWidth * MARGIN_LEFT_RATIO)))
        val marginPxTop = convertDpToPx(convertPxToDp((pixelHeight * MARGIN_TOP_RATIO)))
        val marginPxBottom = convertDpToPx(convertPxToDp((pixelHeight * MARGIN_BOTTOM_RATIO)))
        val marginPxRight = convertDpToPx(convertPxToDp((pixelWidth * MARGIN_RIGHT_RATIO)))

        val layoutParameter = testButton.layoutParams as LayoutParams
        layoutParameter.setMargins(marginPxLeft, marginPxTop, marginPxRight, marginPxBottom)
        testButton.layoutParams = layoutParameter
    }

//    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
//        val action: Int = ev!!.action
//        Log.d(TAG, "##action value: $action")
//
//        Log.d(TAG, "##DOWN: ${MotionEvent.ACTION_DOWN}")
//
//        when (action) {
//            MotionEvent.ACTION_DOWN -> {
//                if (isShadow) {
//                    Log.d(TAG, "##shadow down: $shadow")
//                    shadow.visibility = View.INVISIBLE
//                }
//                return true
//                isShadow = false
//               checkingChangeRenderShadow()
//            }
//
//            MotionEvent.ACTION_UP -> {
//                if (isShadow) {
//                    Log.d(TAG, "##shadow down: $shadow")
//                    shadow.visibility = View.INVISIBLE
//                }
//                return true
//            }
//
//            MotionEvent.ACTION_UP -> {
//                performClick()
//
//            }
//
//        }
//        return super.dispatchTouchEvent(ev)
//    }

//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        when(event?.action){
//            MotionEvent.ACTION_DOWN -> {
//                if(isShadow){
//                    Log.d(TAG, "##shadow down: $shadow")
//                    shadow.visibility = View.INVISIBLE
//                }
//                return true
//            }
//
//
//            MotionEvent.ACTION_UP ->{
//                if(isShadow){
//                    Log.d(TAG, "##shadow up: $shadow")
//                    shadow.visibility = View.VISIBLE
//                }
//                return true
//            }
//
//
//        }
//
//        return super.onTouchEvent(event)
//    }

    override fun performClick(): Boolean {
        super.performClick()
        Log.d(TAG, "##layout null? $layoutView")
        testButton.setOnClickListener {
            onFlatButtonClickListener?.let {
                it(this)
                Log.d(TAG, "##isShadow ACTION_UP: $isShadow")
            }
        }

        return true
    }

    private fun showShadow(isShow: Boolean) {
        Log.d(TAG, "##isShow: $isShow")
        if (!isShadow) {
            return
        }

        if(isShow){

            shadow.visibility = View.VISIBLE
        } else {

            shadow.visibility = View.INVISIBLE
        }
    }
}
typealias OnGlideCircleButtonClickListener = (v: View) -> Unit

