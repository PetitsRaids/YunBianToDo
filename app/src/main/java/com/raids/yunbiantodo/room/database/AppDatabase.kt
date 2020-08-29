package com.raids.yunbiantodo.room.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raids.yunbiantodo.MyApplication
import com.raids.yunbiantodo.room.bean.ToDo
import com.raids.yunbiantodo.room.bean.ToDoList
import com.raids.yunbiantodo.room.dao.ToDoDao
import com.raids.yunbiantodo.room.dao.ToDoListDao
import com.raids.yunbiantodo.support.utils.MyConstValue

@Database(entities = [ToDoList::class, ToDo::class], version = 0)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        val database: AppDatabase by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Room.databaseBuilder(
                MyApplication.context,
                AppDatabase::class.java,
                MyConstValue.DATABASE_NAME
            ).build()
        }
    }

    abstract fun getToDoListDao(): ToDoListDao

    abstract fun getToDoDao(): ToDoDao
}