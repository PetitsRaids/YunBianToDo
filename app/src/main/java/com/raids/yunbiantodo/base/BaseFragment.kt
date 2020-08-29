package com.raids.yunbiantodo.base

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.raids.yunbiantodo.R
import com.raids.yunbiantodo.base.empty.EmptyCreateView
import com.raids.yunbiantodo.base.todoitfs.ICreateView
import com.raids.yunbiantodo.base.todoitfs.IDialogFragmentDismiss
import com.raids.yunbiantodo.base.todoitfs.IDialogInterface
import com.raids.yunbiantodo.support.utils.MyConstValue
import com.raids.yunbiantodo.view.dialog.AddToDoDialogFragment

abstract class BaseFragment() : Fragment() {

    private lateinit var navController: NavController

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navController = Navigation.findNavController(requireView())
        initViewAndData()
    }

    protected fun getNavController(): NavController {
        return navController
    }

    protected fun showDialog(
        viewId: Int,
        positiveTextId: Int,
        dialogInterface: IDialogInterface
    ) {
        showDialog(viewId, positiveTextId, EmptyCreateView(), dialogInterface)
    }

    protected fun showDialog(
        viewId: Int,
        positiveTextId: Int,
        createView: ICreateView,
        dialogInterface: IDialogInterface
    ) {
        val view: View = LayoutInflater.from(requireContext()).inflate(viewId, null, false)
        Log.d(MyConstValue.TAG, "view is $view.")
        createView.createView(view)
        val builder = AlertDialog.Builder(requireContext())

        builder.setView(view)
            .setPositiveButton(positiveTextId) { dialog, _ ->
                dialogInterface.doSomethingWithView(view)
                dialog.dismiss()
            }
            .setNegativeButton(R.string.cancel) { dialog, _ -> dialog.dismiss() }
        builder.create().show()
    }

    protected fun showDialogFragment(dismiss: IDialogFragmentDismiss) {
        val addToDoDialogFragment = AddToDoDialogFragment()
        addToDoDialogFragment.setAddAndCancelListener(dismiss)
//        addToDoDialogFragment.onDismiss(dialogInterface)
        addToDoDialogFragment.show(requireActivity().supportFragmentManager, "2")
    }

    protected abstract fun initViewAndData()
}