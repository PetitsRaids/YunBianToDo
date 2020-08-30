package com.raids.yunbiantodo.room.dao

import androidx.room.*
import com.raids.yunbiantodo.room.bean.ToDoList

@Dao
interface ToDoListDao {

    @Query("SELECT * FROM todo_list")
    fun getAllList(): List<ToDoList>

    @Delete
    fun removeList(listId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToDoList(toDoList: ToDoList)
}