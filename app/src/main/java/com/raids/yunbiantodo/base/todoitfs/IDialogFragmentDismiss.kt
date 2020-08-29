package com.raids.yunbiantodo.base.todoitfs

import com.raids.yunbiantodo.support.utils.ToDoType

interface IDialogFragmentDismiss {
    fun onAdd(todoName: String, toDoType: ToDoType)

    fun onCancel()

    fun onDismiss()
}