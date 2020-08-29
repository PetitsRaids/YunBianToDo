package com.raids.yunbiantodo.support.utils

object MyConstValue {

    const val TAG: String = "YunBianToDo"

    const val UAI: String = "Urgent and Important"
    const val UAI_CODE = 0

    const val NUBI: String = "Not Urgent but Important"
    const val NUBI_CODE = 1

    const val UBNI: String = "Urgent but Not Important"
    const val UBNI_CODE = 2

    const val NAN: String = "Not Urgent and Not Important"
    const val NAN_CODE = 3

    const val EE: String = "Everyday Event"
    const val EE_CODE = 4

    const val DATABASE_NAME: String = "ToDoBase"

    val todoTypeList: ArrayList<String> = arrayListOf(
        EE, NAN, NUBI, UAI, UBNI
    )

    const val INPUT_MODEL = true
    const val BROWSE_MODEL = false
}