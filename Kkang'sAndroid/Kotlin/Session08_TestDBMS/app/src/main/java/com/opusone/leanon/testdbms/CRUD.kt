package com.opusone.leanon.testdbms

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

object CRUD {
    fun insert(context: Context, title: String, content: String){
        val helper = DBHelper(context)
        val db = helper.writableDatabase


        db.execSQL("insert into kotlin_memodb (title, content) values(?,?)",
            arrayOf(title, content))
        db.close()
    }
}