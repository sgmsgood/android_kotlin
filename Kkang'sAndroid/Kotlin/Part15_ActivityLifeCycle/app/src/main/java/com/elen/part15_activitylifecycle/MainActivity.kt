package com.elen.part15_activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val listView: ListView? = null
    val datas = ArrayList<String>()
    lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datas.add("onCreate...")

        adapter = ArrayAdapter<String>(this, R.layout.item_main_list, datas)
        listView?.adapter = adapter

        detailBtn.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        dialogBtn.setOnClickListener {
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        datas.add("onResume....")
        adapter.notifyDataSetChanged()
    }

    override fun onPause() {
        super.onPause()
        datas.add("onPause....")
        adapter.notifyDataSetChanged()
    }

    override fun onStart() {
        super.onStart()
        datas.add("onStart....")
        adapter.notifyDataSetChanged()
    }

    override fun onStop() {
        super.onStop()
        datas.add("onStop....")
        adapter.notifyDataSetChanged()
    }

    override fun onRestart() {
        super.onRestart()
        datas.add("onRestart....")
        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        datas.add("onDestory....")
        adapter.notifyDataSetChanged()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        datas.add("onSaveInstanceState")
        adapter.notifyDataSetChanged()

        outState.putString("data1", "hello")
        outState.putInt("data2", 100)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        datas.add("onRestoreInstanceState")
        adapter.notifyDataSetChanged()

        val data1 = savedInstanceState.getString("data1")
        val data2 = savedInstanceState.getInt("data2")

        Toast.makeText(this, "$data1 : $data2", Toast.LENGTH_SHORT).show()
    }
}
