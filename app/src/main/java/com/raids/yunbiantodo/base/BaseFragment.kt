package com.raids.yunbiantodo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.raids.yunbiantodo.R

abstract class BaseFragment() : Fragment() {

    private lateinit var navController: NavController

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navController = Navigation.findNavController(requireView())
        initView()
    }

    protected fun getNavController(): NavController {
        return navController
    }

    protected fun showDialog(
        viewId: Int,
        positiveTextId: Int,
        dialogInterface: IDialogInterface
    ) {
        val view: View = LayoutInflater.from(requireContext()).inflate(viewId, null, false)
        AlertDialog.Builder(requireContext())
            .setView(view)
            .setPositiveButton(positiveTextId) { dialog, _ ->
                dialogInterface.doSomethingWithView(view)
                dialog.dismiss()
            }
            .setNegativeButton(R.string.cancel) { dialog, _ -> dialog.dismiss() }
            .show()
    }

    protected abstract fun initView()
}