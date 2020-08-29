package com.raids.yunbiantodo.view.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.raids.yunbiantodo.R
import com.raids.yunbiantodo.base.BaseDialogFragment
import com.raids.yunbiantodo.base.todoitfs.IDialogFragmentDismiss
import com.raids.yunbiantodo.support.utils.MyConstValue
import com.raids.yunbiantodo.support.utils.ToDoType
import com.raids.yunbiantodo.support.utils.toast

class AddToDoDialogFragment : BaseDialogFragment() {

    private lateinit var spinner: Spinner
    private lateinit var addToDoEditText: EditText
    private lateinit var dismiss: IDialogFragmentDismiss
    private var currentItem: Int = 0

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.d(MyConstValue.TAG, "onCreateDialog")
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        val dialogView =
            LayoutInflater.from(requireContext()).inflate(R.layout.dialog_add_todo, null, false)
        spinner = dialogView.findViewById(R.id.todo_type_spinner)
        spinner.adapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_spinner_item,
            MyConstValue.todoTypeList
        )
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d(MyConstValue.TAG, "nothing")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                currentItem = position
            }

        }
        // ToDo get selected item position
        addToDoEditText = dialogView.findViewById(R.id.add_todo_editText)
        dialogBuilder.setView(dialogView)
        dialogBuilder.setPositiveButton(
            R.string.add
        ) { _, _ -> dismiss.onAdd(addToDoEditText.text.toString(), getToDoType()) }
        dialogBuilder.setNegativeButton(
            R.string.cancel
        ) { _, _ -> dismiss.onCancel() }
        return dialogBuilder.create()
    }

    private fun getToDoType(): ToDoType {
        return ToDoType.values()[currentItem]
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        dismiss.onDismiss()
    }

    fun setAddAndCancelListener(dismiss: IDialogFragmentDismiss) {
        this.dismiss = dismiss
    }
}