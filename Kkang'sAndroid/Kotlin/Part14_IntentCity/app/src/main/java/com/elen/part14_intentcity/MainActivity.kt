package com.elen.part14_intentcity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener{
    lateinit var adapter:ArrayAdapter<String>
    var datas = ArrayList<String>()

    var category: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainListView.setOnItemClickListener(this)

        val helper = DBHelper(this)
        val db = helper.writableDatabase
        val cursor = db.rawQuery("select location from tb_data where category='0'", null)
        datas = ArrayList()
        while(cursor.moveToNext()){
            datas.add(cursor.getString(0))
        }
        db.close()

        adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, datas)
        mainListView.adapter = adapter
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val textView = view as TextView
        category = textView.text.toString()

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("category", category)

        startActivityForResult(intent, 10)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 10 && resultCode == Activity.RESULT_OK){
            val location = data?.getStringExtra("location")

            Toast.makeText(this, "$category : $location", Toast.LENGTH_SHORT).show()
        }
    }
}