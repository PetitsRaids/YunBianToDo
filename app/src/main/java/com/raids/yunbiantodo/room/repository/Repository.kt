package com.raids.yunbiantodo.room.repository

import com.raids.yunbiantodo.room.database.AppDatabase

class Repository private constructor() {

    private var database: AppDatabase = AppDatabase.database

    companion object {
        val repository: Repository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Repository()
        }
    }


}