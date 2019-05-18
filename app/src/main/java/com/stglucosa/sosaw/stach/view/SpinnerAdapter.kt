package com.stglucosa.sosaw.stach.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.stglucosa.sosaw.stach.R

/**
 * @author Luis L. Polimentes
 * Description:
 * created on 21/06/2018
 */
class SpinnerAdapter(val items: Array<String>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_spinner, parent, false)
        val tvText: TextView = view.findViewById(R.id.tvText)
        tvText.text = items[position]
        return view
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

}