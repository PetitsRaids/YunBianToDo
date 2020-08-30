package com.raids.yunbiantodo.room.repository

import com.raids.yunbiantodo.room.bean.ToDo
import com.raids.yunbiantodo.room.bean.ToDoList
import com.raids.yunbiantodo.room.database.AppDatabase

class Repository private constructor() {

    private var database: AppDatabase = AppDatabase.database
    private val todoListDao = database.getToDoListDao()
    private val toDoDao = database.getToDoDao()

    companion object {
        val repository: Repository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Repository()
        }
    }

    /*----------fun base on TodoListDao----------*/
    public fun getAllToDoLists() : List<ToDoList>{
        return todoListDao.getAllList()
    }

    public fun removeToDoList(listId: Int) {
        todoListDao.removeList(listId)
    }

    public fun insertToDoList(toDoList: ToDoList) {
        todoListDao.insertToDoList(toDoList)
    }

    /*----------fun for on TodoDao----------*/
    public fun getAllToDoByListId(listId:Int) : List<ToDo> {
        return toDoDao.getAllToDoByListId(listId)
    }

    public fun removeToDo(todoId:Int) {
        toDoDao.deleteByToDoId(todoId)
    }

    public fun insertToDo(toDo: ToDo) {
        toDoDao.insertToDo(toDo)
    }

}