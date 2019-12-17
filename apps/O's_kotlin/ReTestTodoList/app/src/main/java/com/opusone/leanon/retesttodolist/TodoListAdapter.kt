package com.opusone.leanon.retesttodolist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.realm.OrderedRealmCollection
import io.realm.RealmBaseAdapter
import java.text.DateFormat

class TodoListAdapter(realmResult: OrderedRealmCollection<Todo>) :
    RealmBaseAdapter<Todo>(realmResult) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val viewHolder: ViewHolder
        val view: View

        if (convertView == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.item_todo, parent, false)

            viewHolder = ViewHolder(view)
            view.tag = viewHolder

        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder

        }

        if(adapterData != null){
            val item = adapterData!![position]
            viewHolder.textTextView.text = item.title
            viewHolder.dateTextView.text = DateFormat.getTimeInstance(3).format(item.date).toString()
        }

        return view
    }

    class ViewHolder(view: View){
        val dateTextView: TextView = view.findViewById(R.id.text1)
        val textTextView: TextView = view.findViewById(R.id.text2)
    }
}