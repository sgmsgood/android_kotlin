package com.opusone.leanon.session10_adapterview

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    //java: String[] arrayDatas
    var arrayDatas = arrayOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrayDatas = resources.getStringArray(R.array.location)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayDatas)
        mainListViewArray.adapter = arrayAdapter

        var simpleDatas: ArrayList<HashMap<String, String>> = ArrayList()
        val helper = DBHelper(this)
        val db = helper.writableDatabase

        val cursor = db.rawQuery("select * from tb_data", null)

        while (cursor.moveToNext()) {
            val map = HashMap<String, String>()
            map.put("name", cursor.getString(1))
            map.put("content", cursor.getString(2))

            simpleDatas.add(map)
        }

        val adapter = SimpleAdapter(this, simpleDatas, android.R.layout.simple_list_item_2,
            arrayOf("name", "content"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        mainListViewSimple.adapter = adapter


        val cursorAdapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_2,
            cursor,
            arrayOf("name", "content"),
            intArrayOf(android.R.id.text1, android.R.id.text2),
            CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER)
        maintListViewCursor.adapter = cursorAdapter
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, "${arrayDatas[position]}", Toast.LENGTH_SHORT).show()
    }


}
