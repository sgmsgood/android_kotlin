package com.opusone.leanon.session10_adapterview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ResourceCursorAdapter
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.core.content.res.ResourcesCompat

class DriveAdapter(context: Context, var resId: Int, val data: MutableList<DriveVO>) :
    ArrayAdapter<DriveVO>(context, resId, data) {

    override fun getCount(): Int {
        return super.getCount()
    }

    @NonNull
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            inflater.inflate(resId, null)
            val holder= DriveHolder(convertView)
            convertView?.setTag(holder)
        }

        val holder = convertView?.getTag() as DriveHolder
        val typeImageView = holder.typeImageView
        val titleView = holder.titleView
        val dateView = holder.dateView
        val menuImageView = holder.menuImageView

        val vo = data.get(position)
        titleView?.text = vo.title
        dateView?.text = vo.date

        if(vo.type.equals("doc")){
            typeImageView?.setImageDrawable(ResourcesCompat.getDrawable(context.resources, R.drawable.ic_type_doc, null))
        } else if(vo.type.equals("file")){
            typeImageView?.setImageDrawable(ResourcesCompat.getDrawable(context.resources, R.drawable.ic_type_file, null))
        } else if(vo.type.equals("img")){
            typeImageView?.setImageDrawable(ResourcesCompat.getDrawable(context.resources, R.drawable.ic_type_image, null))
        }

        menuImageView?.setOnClickListener {
            Toast.makeText(context, "${vo.title} menu click", Toast.LENGTH_SHORT).show()
        }

        return super.getView(position, convertView, parent)
    }


}