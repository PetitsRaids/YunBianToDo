package com.raids.yunbiantodo.room.converter

import androidx.room.TypeConverter
import com.raids.yunbiantodo.support.utils.ToDoType
import com.raids.yunbiantodo.support.utils.todoCode2toDoType
import com.raids.yunbiantodo.support.utils.todoType2toDoCode

class ToDoTypeConverter {

    @TypeConverter
    fun todoType2Code(toDoType: ToDoType) :Int {
        return todoType2toDoCode(toDoType)
    }

    @TypeConverter
    fun todoCode2Type(code:Int) :ToDoType {
        return todoCode2toDoType(code)
    }
}