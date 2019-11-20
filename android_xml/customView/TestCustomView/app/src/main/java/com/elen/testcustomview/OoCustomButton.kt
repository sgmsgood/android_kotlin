package com.elen.testcustomview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.opus_custom_button.view.*
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log


class OoCustomButton@JvmOverloads constructor(context: Context,
                                              attrs: AttributeSet? = null,
                                              defStyleAttr: Int = 0): ConstraintLayout(context, attrs, defStyleAttr) {
    private val TAG = "OoCustomButton"

    init {
        LayoutInflater.from(context).inflate(R.layout.opus_custom_button, this, true)
        attrs?.let { getAttrs(it, defStyleAttr) };

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val displayMetrics = context.getResources().getDisplayMetrics()
        val buttonWidth = ((heightSize/displayMetrics.density)+0.5)
        Log.d(TAG, "##button $buttonWidth")
        
        if (widthMode != MeasureSpec.EXACTLY) {

            throw IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (heightMode != MeasureSpec.EXACTLY) {
            throw IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
    }

    private fun getAttrs(attrs: AttributeSet, defStyle: Int) {
        val typedArray: TypedArray = getContext().obtainStyledAttributes(attrs, R.styleable.OoCustomButton, defStyle, 0)
        setTypeArray(typedArray)
    }

    private fun setTypeArray(typedArray: TypedArray ) {
        val text_string: String? = typedArray.getString(R.styleable.OoCustomButton_custome_text)
        button.setText(text_string)

//        val width_size = typedArray.getDimension(R.styleable.OoCustomButton_custome_width)
//        typedArray.recycle()
    }

    fun setText(text_string: String ) {
        button.setText(text_string)
    }

    fun setText(text_resID: Int ) {
        button.setText(text_resID);
    }


}
