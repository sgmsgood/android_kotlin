package com.example.testankoalert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initWidget()
    }

    private fun initWidget() {
        goToHell.setOnClickListener{
            finish()
        }

        goToHeaven.setOnClickListener {
            OoAlertManager.confirm(this, "용이 배 안고파??", "하"){
                Log.d("MainActivity", "##secondActivity")
            }
        }
    }
}
