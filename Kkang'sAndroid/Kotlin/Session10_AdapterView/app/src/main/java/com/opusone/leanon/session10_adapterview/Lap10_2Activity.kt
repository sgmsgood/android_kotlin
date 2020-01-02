package com.opusone.leanon.session10_adapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_lap10_2.*

class Lap10_2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lap10_2)

        val helper = DBHelper(this)
        val db = helper.writableDatabase
        val cursor = db.rawQuery("select * from tb_drive", null)

        val data = ArrayList<DriveVO>()
        while(cursor.moveToNext()){
            val vo = DriveVO()
            vo.type = cursor.getString(3)
            vo.title = cursor.getString(1)
            vo.date = cursor.getString(2)
            data.add(vo)
        }

        db.close()

        val adapter = DriveAdapter(this, R.layout.custom_item, data)
        custom_listview.adapter = adapter
    }

}
