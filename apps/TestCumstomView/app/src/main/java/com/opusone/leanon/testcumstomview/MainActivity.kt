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
        Log.d("MainActivity", "### difficult")
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "### difficult")
        setContentView(R.layout.activity_main)

        first.onClickListener = ::onClickButton
    }

    private fun onClickButton(view: View) {
        Toast.makeText(this, "Clicked firstBtn", Toast.LENGTH_SHORT).show()
    }

    private fun onClickButton2(view: View) {
        Toast.makeText(this, "Clicked secondBtn", Toast.LENGTH_SHORT).show()
    }


}
