package com.elena.estrella.SelfCoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initWidget()
    }

    private fun initWidget() {
        val adapter = ProjectAdapter()
        adapter.itemClick = object: ProjectAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                Toast.makeText(this@MainActivity, position.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}
