package com.opusone.leanon.testdbms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_read_db.*

class ReadDBActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_db)

        val helper = DBHelper(this)
        val db = helper.writableDatabase
        val cursor = db.rawQuery("select title, content from kotlin_memodb order by _id desc limit 1", null)

        while(cursor.moveToNext()){
            readTitleView.text = cursor.getString(0)
            readContentView.text = cursor.getString(1)
        }

        db.close()
    }
}
