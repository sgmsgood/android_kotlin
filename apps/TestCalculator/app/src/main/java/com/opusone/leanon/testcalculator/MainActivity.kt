package com.opusone.leanon.testcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.opusone.leanon.testcalculator.Calculator.division
import com.opusone.leanon.testcalculator.Calculator.minus
import com.opusone.leanon.testcalculator.Calculator.multiple
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var resultValue = 0.0
    var leftInputValue = 0.0
    var rightInputValue = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sumButton.setOnClickListener {
            leftInputValue = leftInput.text.toString().toDouble()
            rightInputValue = rightInput.text.toString().toDouble()


            resultValue = Calculator.cal(leftInputValue, rightInputValue, Calculator::sum)
        }

        minusButton.setOnClickListener {
            leftInputValue = leftInput.text.toString().toDouble()
            rightInputValue = rightInput.text.toString().toDouble()

            resultValue = Calculator.cal(leftInputValue, rightInputValue, Calculator::minus)
        }

        multiplyButton.setOnClickListener {
            leftInputValue = leftInput.text.toString().toDouble()
            rightInputValue = rightInput.text.toString().toDouble()

            resultValue = Calculator.cal(leftInputValue, rightInputValue, Calculator::multiple)
        }

        divisionButton.setOnClickListener {
            leftInputValue = leftInput.text.toString().toDouble()
            rightInputValue = rightInput.text.toString().toDouble()

            resultValue = Calculator.cal(leftInputValue, rightInputValue, Calculator::division)
        }

        clearButton.setOnClickListener {
            leftInput.setText("0")
            rightInput.setText("0")
            resultText.text = ""
        }

        calButton.setOnClickListener {
            resultText.text = resultValue.toString()
        }

    }
}
