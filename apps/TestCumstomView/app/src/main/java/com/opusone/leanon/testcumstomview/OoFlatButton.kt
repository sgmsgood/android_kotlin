package com.opusone.leanon.testcumstomview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.DisplayMetrics
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

    private val MARGIN_RATIO = 0.12

    private var pixelWidth = 0
    private var pixelHeight = 0

    private var textString = ""
    private var textColor = R.color.selector_button_text
    private var fontSize = 0
    private var bgButton = 0
    private var iconImage = 0

    private var isShadow = true
    private var isKeepShadowMargin = true

    private var isProcessingTouchEvent = false

    var onFlatButtonClickListener: ((view: View) -> Unit)? = null

    private var layoutView: View? = null

    var marginPx = 0

    var onClickListener: ((view: View) -> Unit)? = null
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

        setButtonAttr()
        renderShadow()
        renderShadowMargin()
    }

    private fun parseAttrs(attrsArray: TypedArray) {
        textString = attrsArray.getString(R.styleable.OoFlatButton_Text) ?: ""

        fontSize = attrsArray.getDimensionPixelSize(R.styleable.OoFlatButton_FontSize, 21)

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

        iconImage = attrsArray.getResourceId(R.styleable.OoFlatButton_iconImage, 0)
    }

    private fun convertSpToPx(pxFontSize: Int): Float{
        return pxFontSize/resources.displayMetrics.scaledDensity
    }

    private fun convertPxToDp(px: Int): Double{
        val displayMetrics = context.resources.displayMetrics
        return (px / displayMetrics.density).toDouble()
    }

    private fun convertDpToPx(dp: Int): Double {
        val displayMetrics = context.resources.displayMetrics
        return (dp * displayMetrics.density).toDouble()
    }

    private fun renderShadow() {
        if (isProcessingTouchEvent) {
            return
        }
        shadow.visibility = if (isShadow) View.VISIBLE else View.GONE
    }

    private fun renderShadowMargin() {
        if (isKeepShadowMargin) {
            getSquareTypeMargin(pixelWidth, pixelHeight)

        } else {
            getSquareTypeMargin(0, 0)
        }
    }

    private fun setButtonAttr() {
        innerButton.text = textString
        innerButton.textSize = convertSpToPx(fontSize)
        innerButton.setBackgroundResource(bgButton)
        innerButton.setTextColor(resources.getColorStateList(textColor, null))
    
//        val image = context.resources.getDrawable(iconImage, null)
//        image.setBounds(0, 0, (pixelWidth * 0.2).toInt(), (pixelHeight *  0.48).toInt())
//        innerButton.setCompoundDrawables(image, null, null, null)
//
        val image = context.resources.getDrawable(iconImage, null)
        val dpImageWidth = convertPxToDp(image.intrinsicWidth)/convertPxToDp(pixelWidth)
        val dpImageHeight = convertPxToDp(image.intrinsicHeight)/convertPxToDp(pixelHeight)

        val dp = convertPxToDp(dpImageHeight.toInt())

        val textWidth = fontSize * (textString.length+1)

        val margineLeftValue = ((pixelWidth - (image.intrinsicWidth + textWidth)) / 2)
        val margineTopValue = ((pixelHeight - getSquareTypeMargin(pixelWidth, pixelHeight)*2 -(image.intrinsicWidth+fontSize))/2)

        image.setBounds(0, 0, (pixelWidth * dpImageWidth).toInt(), (pixelHeight *  dpImageHeight).toInt())
        innerButton.setCompoundDrawables(null, image, null, null)
        innerButton.setPadding(0, margineTopValue, 0, 0)
    }

    private fun getSquareTypeMargin(pixelWidth: Int, pixelHeight: Int): Int{

        var size = Pair(pixelWidth, pixelHeight)
        if (size.first - size.second > 0) {
            size = Pair(pixelHeight, pixelWidth)
        }

        try {
            var sizeRatio = size.second / size.first

            marginPx = (size.first * MARGIN_RATIO * sizeRatio).toInt()
            setMargin(marginPx, marginPx, marginPx, marginPx)

        }catch (e: ArithmeticException){
            e.printStackTrace()
        }

        return marginPx

    }

    private fun setMargin(marginPxLeft: Int, marginPxTop: Int, marginPxRight: Int, marginPxBottom: Int) {
        val layoutParameter = innerButton.layoutParams as LayoutParams
        layoutParameter.setMargins(marginPxLeft, marginPxTop, marginPxRight, marginPxBottom)
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

