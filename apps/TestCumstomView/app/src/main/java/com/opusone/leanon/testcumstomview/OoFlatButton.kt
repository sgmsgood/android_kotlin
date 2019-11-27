package com.opusone.leanon.testcumstomview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
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

    private val MARGIN_RATIO = 0.1

    private var pixelWidth = 0
    private var pixelHeight = 0

    private var textString = ""
    private var textColor = R.color.selector_button_text
    private var floatFontSize = 0.0f
    private var bgButton = 0

    private var isShadow = true
    private var isKeepShadowMargin = true

    private var isProcessingTouchEvent = false

    var onFlatButtonClickListener: ((view: View) -> Unit)? = null

    private var layoutView: View? = null

    var onClickListener: ((view: View) -> Unit) ? = null
        set(newValue) {
            innerButton.onButtonClickListener = newValue
        }

    init {
        layoutView = LayoutInflater.from(context).inflate(R.layout.my_custom_view, this, true)

        attrs?.let {
            val attrsArray = context.obtainStyledAttributes(attrs, R.styleable.OoFlatButton, 0, 0)

            parseAttrs(attrsArray)

            innerButton.onShadowListener = ::showShadow
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        pixelWidth = MeasureSpec.getSize(widthMeasureSpec)
        pixelHeight = MeasureSpec.getSize(heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        renderShadow()
        renderShadowMargin()
        setButtonAttr()
    }

    private fun parseAttrs(attrsArray: TypedArray) {
        textString = attrsArray.getString(R.styleable.OoFlatButton_Text) ?: ""

        floatFontSize =
            attrsArray.getDimensionPixelSize(R.styleable.OoFlatButton_FontSize, 0).toFloat()

        bgButton =
            attrsArray.getResourceId(R.styleable.OoFlatButton_BackGround, R.drawable.basic_button)

        textColor =
            attrsArray.getResourceId(
                R.styleable.OoFlatButton_TextColor,
                R.color.selector_button_text
            )

        isShadow = attrsArray.getBoolean(R.styleable.OoFlatButton_isShadow, true)

        isKeepShadowMargin =
            attrsArray.getBoolean(R.styleable.OoFlatButton_isKeepshadowMargin, true)
    }


    private fun renderShadow() {
        if (isProcessingTouchEvent) {
            return
        }
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
        innerButton.text = textString
        innerButton.textSize = floatFontSize
        innerButton.setBackgroundResource(bgButton)
        innerButton.setTextColor(resources.getColorStateList(R.color.selector_button_text, null))
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
//        val marginWidth = pixelWidth-(pixelWidth * 0.95)

        val marginPxLeft = convertDpToPx(convertPxToDp((pixelWidth * MARGIN_LEFT_RATIO)))
//        val marginPxLeft = (marginWidth / 2).toInt()
        val marginPxTop = convertDpToPx(convertPxToDp((pixelHeight * MARGIN_TOP_RATIO)))
        val marginPxBottom = convertDpToPx(convertPxToDp((pixelHeight * MARGIN_BOTTOM_RATIO)))
//        val marginPxRight =(marginWidth / 2).toInt()
        val marginPxRight = convertDpToPx(convertPxToDp((pixelWidth * MARGIN_RIGHT_RATIO)))

//
//        val ldxHeight = pixelHeight * 0.1
//        val ldxWidth = pixelWidth * 0.1
//
//        val marginPxTop = ldxHeight.toInt()
//        val marginPxLeft = ldxWidth.toInt()
//        val marginPxBottom = ldxHeight.toInt()
//        val marginPxRight = ldxWidth.toInt()

//        val marginPxWidth = convertDpToPx(convertPxToDp((pixelWidth * MARGIN_RATIO)))
//        val marginPxHeight = convertDpToPx(convertPxToDp((pixelHeight* MARGIN_RATIO)))

        val layoutParameter = innerButton.layoutParams as LayoutParams
        layoutParameter.setMargins(marginPxLeft, marginPxTop, marginPxRight, marginPxBottom)
//        layoutParameter.setMargins(marginPxWidth, marginPxHeight, marginPxWidth, marginPxHeight)
        innerButton.layoutParams = layoutParameter
    }

    private fun showShadow(isShow: Boolean) {
        Log.d(TAG, "##isShow: $isShow")
        if (!isShadow) {
            return
        }

        if (isShow) {
            shadow.visibility = View.VISIBLE
            isProcessingTouchEvent = false


        } else {
            isProcessingTouchEvent = true
            shadow.visibility = View.INVISIBLE

        }
    }
}

