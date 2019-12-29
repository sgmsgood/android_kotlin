package com.opusone.leanon.session10_adapterview

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(
    context, "datadb", null, 8
) {

    override fun onCreate(db: SQLiteDatabase?) {
        val tableSql = "create table tb_data ("+
                "_id integer primary key autoincrement," +
                "name not null," +
                "content)"

        db?.execSQL(tableSql)

        db?.execSQL("insert into tb_data(name, content) values ('류이호', '파이팅')")
        db?.execSQL("insert into tb_data(name, content) values ('임준걸', '내년도 파이팅')")


        val driverTable = "create table tb_drive (" +
                "_id integer primary key autoincrement,"+
                "title," +
                "date," +
                "type)"

        db?.execSQL(driverTable)
        db?.execSQL("insert into tb_drive (title, date, type) values ('안드로이드','최종 수정 날짜 : 2월 6일', 'doc')")
        db?.execSQL("insert into tb_drive (title, date, type) values ('db.zip','최종 수정 날짜 : 1월 16일', 'file')")
        db?.execSQL("insert into tb_drive (title, date, type) values ('하이브리드','최종 수정 날짜 : 1월 8일', 'doc')")
        db?.execSQL("insert into tb_drive (title, date, type) values ('이미지1','최종 수정 날짜 : 1월 1일', 'img')")
        db?.execSQL("insert into tb_drive (title, date, type) values ('Part4','최종 수정 날짜 : 12월 24일', 'file')")
        db?.execSQL("insert into tb_drive (title, date, type) values ('Angular','최종 수정 날짜 : 12월 6일', 'doc')")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if(newVersion == 8){
            db?.execSQL("drop table tb_data");
            db?.execSQL("drop table tb_drive");
            onCreate(db);
        }
    }
}