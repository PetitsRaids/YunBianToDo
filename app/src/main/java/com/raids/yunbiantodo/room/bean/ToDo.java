package com.raids.yunbiantodo.room.bean;

import androidx.room.Entity;

import com.raids.yunbiantodo.support.utils.ToDoType;

import java.util.List;

@Entity(tableName = "todo")
public class ToDo {
    private int id;

    private int listId;

    private String toDoName;

    private boolean isCompleted;

    private ToDoType todoType;

    private String remarks;

    private List<ToDoStep> stepList;

    public ToDo(String toDoName, boolean isCompleted) {
        this.toDoName = toDoName;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getToDoName() {
        return toDoName;
    }

    public void setToDoName(String toDoName) {
        this.toDoName = toDoName;
    }

    public ToDoType getTodoType() {
        return todoType;
    }

    public void setTodoType(ToDoType todoType) {
        this.todoType = todoType;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public List<ToDoStep> getStepList() {
        return stepList;
    }

    public void setStepList(List<ToDoStep> stepList) {
        this.stepList = stepList;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
