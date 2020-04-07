package com.elena.estrella.SelfCoin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class ProjectAdapter : RecyclerView.Adapter<ProjectAdapter.ViewHolder>() {

    var items = mutableListOf("10kg 빼기", "대만 가기", "헤어지기")


    interface ItemClick{
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            items[position].let { item ->
                holder.goal.text = item
            }
            holder?.itemView?.setOnClickListener {
                itemClick?.onClick(it, position)
            }

    }

    class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
    ) {
        var goal = itemView.goalText
    }

    data class SearchData(val goalName: String, val buttonResource: Int)
}