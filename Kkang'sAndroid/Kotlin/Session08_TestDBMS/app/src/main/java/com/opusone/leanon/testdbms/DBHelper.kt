package com.opusone.leanon.testdbms

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, "kotlin_memodb", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val memoSQL = "create table kotlin_memodb " + "(_id integer primary key autoincrement, " +
                "title, " +
                "content)"

        db?.execSQL(memoSQL)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table kotlin_memodb")
        onCreate(db)
    }
}