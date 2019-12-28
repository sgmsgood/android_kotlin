package com.opusone.leanon.testdbms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addBtn.setOnClickListener{
            val title: String = addTitle.text.toString()
            val content: String = addContent.text.toString()

            CRUD.insert(this, title, content)

            val intent = Intent(this, ReadDBActivity::class.java)
            startActivity(intent)
        }
    }
}
