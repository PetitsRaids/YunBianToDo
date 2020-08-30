package com.raids.yunbiantodo.room.dao

import androidx.room.*
import com.raids.yunbiantodo.room.bean.ToDo

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo")
    fun getAllToDoByListId(listId: Int): List<ToDo>

    @Delete
    fun deleteByToDoId(todoId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToDo(toDo: ToDo)
}