package com.raids.yunbiantodo.support.utils

enum class ToDoType {
    UAI, NUBI, UBNI, NAN, EE;
    companion object {
        var count = 0
        fun getInt(toDoType: ToDoType) :Int{
            values().iterator().forEach {
                if (it == toDoType) {
                    return count++
                }
            }
            return -1
        }
    }
}