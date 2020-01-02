package com.elen.part14_intentcity

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(
    context, "mydb", null, 1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val memoSQL= "create table tb_data " +
                "(_id integer primary key autoincrement," + "category," + "location)"

        db?.execSQL(memoSQL)

        db?.execSQL("insert into tb_data (category, location) values ('0', '서울특별시')");
        db?.execSQL("insert into tb_data (category, location) values ('0', '경기도')");

        db?.execSQL("insert into tb_data (category, location) values ('서울특별시', '종로구')");
        db?.execSQL("insert into tb_data (category, location) values ('서울특별시', '강남구')");
        db?.execSQL("insert into tb_data (category, location) values ('서울특별시', '송파구')");

        db?.execSQL("insert into tb_data (category, location) values ('경기도', '성남시')");
        db?.execSQL("insert into tb_data (category, location) values ('경기도', '수원시')");
        db?.execSQL("insert into tb_data (category, location) values ('경기도', '용인시')");
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if(newVersion==1){
            db?.execSQL("drop table tb_data");
            onCreate(db);
        }
    }
}