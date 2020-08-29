package com.raids.yunbiantodo.support.adapter

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raids.yunbiantodo.R
import com.raids.yunbiantodo.room.bean.ToDoList
import com.raids.yunbiantodo.support.utils.MyConstValue
import com.raids.yunbiantodo.support.utils.toast

class ToDoListAdapter(private val context: Context, private val toDoList: ArrayList<ToDoList>) :
    RecyclerView.Adapter<ToDoListAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val listName: TextView = view.findViewById(R.id.listName_textView)
        val icon: ImageView = view.findViewById(R.id.todoList_imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.cell_todo_list, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position == itemCount - 1) {
            Log.d(MyConstValue.TAG, "position is $position.")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Glide.with(context).load(R.drawable.icon_add).into(holder.icon)
            }
            holder.itemView.setOnClickListener {
                toast(R.string.app_name)
            }
        } else {
            holder.listName.text = toDoList[position].listName
            holder.itemView.setOnClickListener {
                val navController = Navigation.findNavController(it)
                navController.navigate(R.id.action_mainFragment_to_singleListFragment)
            }
        }
    }

    override fun getItemCount(): Int {
        return toDoList.size + 1
    }

}