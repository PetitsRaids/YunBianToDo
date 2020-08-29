package com.raids.yunbiantodo.room.bean;

import androidx.room.Entity;

import java.util.List;

@Entity(tableName = "todo_list")
public class ToDoList {

    private int id;

    private String listName;

    private List<ToDo> toDoList;

    public ToDoList(int id, String listName) {
        this.id = id;
        this.listName = listName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public void setToDoList(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }
}
