package com.elen.part14_intentcity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    lateinit var adapter: ArrayAdapter<String>
    var datas = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = getIntent()
        val category: String? = intent.getStringExtra("category")

        detailListView.setOnItemClickListener(this)

        val helper = DBHelper(this)
        val db = helper.writableDatabase
        val cursor = db.rawQuery("select location from tb_data where category=?",
            category?.let { arrayOf(it) })

        datas = ArrayList<String>()
        while(cursor.moveToNext()){
            datas.add(cursor.getString(0))
        }
        db.close()

        adapter =ArrayAdapter(this, android.R.layout.simple_list_item_1, datas)
        detailListView.adapter = adapter
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val textView = view as TextView

        val intent = Intent()
        intent.putExtra("location", textView.text.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
