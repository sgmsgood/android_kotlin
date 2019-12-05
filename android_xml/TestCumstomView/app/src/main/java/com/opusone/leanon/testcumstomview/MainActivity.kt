package com.opusone.leanon.testcumstomview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        all.onClickListener = ::onClickButton
//        second.onClickListener = ::onClickButton2
    }

    private fun onClickButton(view: View) {
        val intent = Intent(this, LauncherMenu::class.java)
        startActivity(intent)

    }

    private fun onClickButton2(view: View) {
        Toast.makeText(this, "Clicked second Btn", Toast.LENGTH_SHORT).show()
    }


}
