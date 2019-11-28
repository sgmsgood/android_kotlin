package com.opusone.leanon.testankodialog

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import androidx.annotation.ColorInt

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.textColor


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        dialogButton1.setOnClickListener {
            showDialog1()
        }

        dialogButton2.setOnClickListener {
            showDialog2()
        }
    }

    private fun showDialog1(){

        alert ("확인되었습니다.", "첫번째 버튼 다이얼로그") {
            also {
                setTheme(R.style.AnkoLightAlertTheme)
            }

            positiveButton("확인") {

            }

            negativeButton("취소") {

            }
        }.show().apply {
            setCancelable(false)
            getButton(AlertDialog.BUTTON_POSITIVE)?.let { it.textColor = Color.parseColor("#008577")}
            getButton(AlertDialog.BUTTON_NEGATIVE)?.let { it.textColor = Color.parseColor("#D81B60") }
        }
    }

    private fun showDialog2(){

        alert ("확인되었습니다.", "두번째 버튼 다이얼로그") {
            also {
                setTheme(R.style.AnkoAlertTheme)
            }

            positiveButton("확인") {

            }

            negativeButton("취소") {

            }
        }.show().apply {
            setCancelable(false)
            getButton(AlertDialog.BUTTON_POSITIVE)?.let { it.textColor = Color.parseColor("#008577")}
            getButton(AlertDialog.BUTTON_NEGATIVE)?.let { it.textColor = Color.parseColor("#D81B60") }
        }
    }

}
