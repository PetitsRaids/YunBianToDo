package com.raids.yunbiantodo.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.raids.yunbiantodo.room.bean.ToDoList

@Dao
interface ToDoListDao {

    @Query("SELECT * FROM todolist")
    fun getAllList(): List<ToDoList>

    fun removeList(listId:Int)
}