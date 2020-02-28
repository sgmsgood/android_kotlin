package com.example.testankoalert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        OoAlertManager.init(true)

        initwidget()
    }

    private fun initwidget() {
        q1.setOnClickListener(::setBasicAlert)

        q2.setOnClickListener {
            OoAlertManager.alert(this, "안녕하시지요?", "네", "아니오", {
                Log.d("MainActivity", "##ggggg")
            }, {
                Log.d("MainActivity", "##ssssss")
            })
        }

        q3.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setBasicAlert(view: View) {
//        val alert = AlertDialog.Builder(this).apply {
//            setIcon(R.drawable.ic_info_pleaseread)
//            setTitle("알림")
//            setMessage("이지수 님이 맞으신가요?")
//            setNeutralButton("Neutral", null)
//            setNegativeButton("No", null)
//            setPositiveButton("OK", null)
//            create()
//        }

        OoAlertManager.confirm(this, "안녕하세요?", "응 안녕"){
        }

        OoAlertManager.confirm(this, "안녕하세요?", "응 안녕", null)
    }
}
