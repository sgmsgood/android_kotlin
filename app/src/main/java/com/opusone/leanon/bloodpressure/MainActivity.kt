package com.opusone.leanon.bloodpressure

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    val fragmentManager: FragmentManager = supportFragmentManager

    val REQUEST_CODE = 200
    val bloodPressureList = listOf("120/80", "140/88", "160/76", "170/112", "110/78", "120/89", "119/68")
    val purseList = listOf("90", "120", "66", "110", "90", "89", "88")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        settingButton.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            intent.addFlags(REQUEST_CODE)
            startActivityForResult(intent, REQUEST_CODE)
        }

        changeFragment(WeekendGraphFragment())
//
//        weekBtn.setOnClickListener {
//            Toast.makeText(this, "???", Toast.LENGTH_SHORT).show()
//            changeFragment(WeekendGraphFragment())
//        }
    }

    private fun initView(){
        Log.d(TAG,"##??")
        val list = mutableListOf<ItemContents>()

        Log.d(TAG, "##listCount: ${list.size}")

        for (i in 0 .. bloodPressureList.size-1){
            Log.d(TAG, "## ${bloodPressureList[i]}, ${purseList[i]}")
            list.add(ItemContents(bloodPressureList[i]+" mmHg", purseList[i]+" bpm"))

            Log.d(TAG, "##listAddedSize: ${list.size}")
        }

        resultRecyclerView.addItemDecoration(object: DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL){
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {

                Log.d(TAG, "##entered resultRecycler")
                val position = parent.getChildAdapterPosition(view)
                if (position == parent.adapter!!.itemCount - 1) {
                    outRect.setEmpty()
                } else {
                    super.getItemOffsets(outRect, view, parent, state)
                }
            }
        })
        resultRecyclerView.adapter = ItemAdapter(list)
    }

    private fun changeFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.graphFragment, fragment).commit();
    }
}
