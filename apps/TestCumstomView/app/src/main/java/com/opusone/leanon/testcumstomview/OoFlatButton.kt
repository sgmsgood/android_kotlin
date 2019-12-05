package com.opusone.leanon.testcumstomview

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.AttributeSet
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

    private var layoutView: View? = null

    private val SHADOW_PX_MARGIN = 42

    private var pixelWidth = 0
    private var pixelHeight = 0

    private var textString = ""
    private var textColor = 0
    private var textSize = 0
    private var fontStyle = 0

    private var background = 0

    private var isShadow = true
    private var isKeepShadowMargin = true

    private var drawableLeft = 0
    private var drawableTop = 0
    private var drawableRight = 0
    private var drawableBottom = 0

    private var drawablePadding = 0
    private var btnPaddingLeft = 0
    private var btnPaddingTop = 0
    private var btnPaddingRight = 0
    private var btnPaddingBottom = 0

    private var isProcessingTouchEvent = false
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
        background =
            attrsArray.getResourceId(
                R.styleable.OoFlatButton_oe_backgroundImg,
                R.drawable.basic_button
            )

        parseShadowAttrs(attrsArray)
        parseDrawableAttrs(attrsArray)
        parsePaddingAttrs(attrsArray)
        parseTextAttrs(attrsArray)
    }

    private fun parseShadowAttrs(attrsArray: TypedArray){
        isShadow = attrsArray.getBoolean(R.styleable.OoFlatButton_oe_isShadow, true)
        isKeepShadowMargin =
            attrsArray.getBoolean(R.styleable.OoFlatButton_oe_isKeepshadowMargin, true)
    }

    private fun parseTextAttrs(attrsArray: TypedArray){
        textString = attrsArray.getString(R.styleable.OoFlatButton_oe_text) ?: ""
        textSize = attrsArray.getDimensionPixelSize(R.styleable.OoFlatButton_oe_textSize, 21)
        textColor = attrsArray.getResourceId(R.styleable.OoFlatButton_oe_textColor, R.color.selector_button_text)
        fontStyle = attrsArray.getResourceId(R.styleable.OoFlatButton_oe_fontStyle, R.font.notosans_m)
    }

    private fun parseDrawableAttrs(attrsArray: TypedArray){
        drawableLeft = attrsArray.getResourceId(R.styleable.OoFlatButton_oe_drawableLeft, 0)
        drawableTop = attrsArray.getResourceId(R.styleable.OoFlatButton_oe_drawableTop, 0)
        drawableRight = attrsArray.getResourceId(R.styleable.OoFlatButton_oe_drawableRight, 0)
        drawableBottom = attrsArray.getResourceId(R.styleable.OoFlatButton_oe_drawableBottom, 0)
    }

    private fun parsePaddingAttrs(attrsArray: TypedArray){
        drawablePadding = attrsArray.getDimensionPixelSize(R.styleable.OoFlatButton_oe_drawablePadding, 0)
        btnPaddingLeft =
            attrsArray.getDimensionPixelSize(R.styleable.OoFlatButton_oe_paddingLeft, 0)
        btnPaddingTop =
            attrsArray.getDimensionPixelSize(R.styleable.OoFlatButton_oe_paddingTop, 0)
        btnPaddingRight =
            attrsArray.getDimensionPixelSize(R.styleable.OoFlatButton_oe_paddingRight, 0)
        btnPaddingBottom =
            attrsArray.getDimensionPixelSize(R.styleable.OoFlatButton_oe_paddingBottom, 0)
    }

    private fun renderShadow() {
        if (isProcessingTouchEvent) {
            return
        }
        shadow.visibility = if (isShadow) View.VISIBLE else View.GONE
    }

    private fun renderShadowMargin() {
        if (isKeepShadowMargin) {
            val layoutParameter = innerButton.layoutParams as LayoutParams
            layoutParameter.setMargins(
                SHADOW_PX_MARGIN,
                SHADOW_PX_MARGIN,
                SHADOW_PX_MARGIN,
                SHADOW_PX_MARGIN
            )
            innerButton.layoutParams = layoutParameter
        }
    }

    private fun setButtonAttr() {
        innerButton.text = textString
        innerButton.textSize = convertSpToPx(textSize)
        innerButton.setTextColor(resources.getColorStateList(textColor, null))

        innerButton.setBackgroundResource(background)
        innerButton.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom)

        setBtnPadding()
        setFont()
        setDrawableIcon()
    }

    private fun setFont() {
        var fontType: Typeface = resources.getFont(fontStyle)
        innerButton.setTypeface(fontType)
    }

    private fun setBtnPadding(){
        innerButton.setPadding(btnPaddingLeft, btnPaddingTop, btnPaddingRight, btnPaddingBottom)
        innerButton.compoundDrawablePadding = drawablePadding
    }

    private fun setDrawableIcon() {

    }

    private fun showShadow(isShow: Boolean) {
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

    private fun convertSpToPx(sp: Int): Float {
        return sp / resources.displayMetrics.scaledDensity
    }
}

