package com.raids.yunbiantodo.room.bean;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "todo_list")
public class ToDoList {

    @PrimaryKey
    private int id;

    private String listName;


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

}
