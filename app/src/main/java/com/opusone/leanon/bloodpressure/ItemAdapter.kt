package com.opusone.leanon.bloodpressure

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_item.view.*


class ItemAdapter(var list: MutableList<ItemContents>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val TAG = "ItemAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d(TAG, "##entered here")
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = holder as ViewHolder
        val item = list[position]

        Log.d(TAG, "##position: $position")

        view.pressure.text = item.pressure
        view.purse.text = item.purse
        Log.d(TAG, "##list.count: ${list.count().toString()},  ${item.pressure}")
        view.layout.setOnClickListener {
            Toast.makeText(
                holder.layout.context,
                "pressure: ${item.pressure}, purse: ${item.purse}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layout = itemView.itemLayout
        val pressure = itemView.bloodPressureValue
        val purse = itemView.purseValue
    }
}