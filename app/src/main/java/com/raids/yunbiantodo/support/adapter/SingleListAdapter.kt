package com.raids.yunbiantodo.support.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.raids.yunbiantodo.R
import com.raids.yunbiantodo.bean.ToDo
import com.raids.yunbiantodo.support.utils.toast

class SingleListAdapter(private val context: Context, private val singleList:ArrayList<ToDo>) : RecyclerView.Adapter<SingleListAdapter.ViewHolder>() {

    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        val checkbox: CheckBox = view.findViewById(R.id.checkbox_single_list)
        val todoName:TextView = view.findViewById(R.id.todoName_single_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder(LayoutInflater.from(context).inflate(R.layout.cell_single_list, parent, false))
        viewHolder.itemView.setOnClickListener {
            toast(R.string.des_todo_icon)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.checkbox.isChecked = singleList[position].isCompleted
        holder.todoName.text = singleList[position].toDoName
    }

    override fun getItemCount(): Int {
        return singleList.size
    }

}