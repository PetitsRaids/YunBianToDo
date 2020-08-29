package com.raids.yunbiantodo.view.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.raids.yunbiantodo.R
import com.raids.yunbiantodo.support.adapter.SingleListAdapter
import com.raids.yunbiantodo.base.BaseFragment
import com.raids.yunbiantodo.base.todoitfs.IDialogFragmentDismiss
import com.raids.yunbiantodo.room.bean.ToDo
import com.raids.yunbiantodo.support.utils.MyConstValue
import com.raids.yunbiantodo.support.utils.ToDoType
import com.raids.yunbiantodo.support.utils.toast
import com.raids.yunbiantodo.viewmodel.SingleFragmentViewModel

class SingleListFragment : BaseFragment() {

    private lateinit var viewModel: SingleFragmentViewModel

    private lateinit var singleListRecyclerView: RecyclerView
    private lateinit var singleListAdapter: SingleListAdapter
    private lateinit var addToDoFab: FloatingActionButton

    private lateinit var dialogDismissed: DialogInterface

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_single_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        addToDoFab.setOnClickListener {
            viewModel.setInputState(MyConstValue.INPUT_MODEL)
            showDialogFragment(object : IDialogFragmentDismiss {
                override fun onAdd(todoName: String, toDoType: ToDoType) {
                    toast("todoName is $todoName and todoType is $toDoType.")
                    toBrowseModel()
                }

                override fun onCancel() {
                    toast("cancel")
                    toBrowseModel()
                }

                override fun onDismiss() {
                    Log.d(MyConstValue.TAG, "dismiss")
                }
            })
        }

        viewModel.isInputtingLive.observe(viewLifecycleOwner,
            Observer<Boolean> {
                if (it) {
                    toInputModel()
                } else {
                    toBrowseModel()
                }
            })
    }

    override fun initViewAndData() {
        singleListRecyclerView = requireView().findViewById(R.id.singleList_recyclerView)
        addToDoFab = requireView().findViewById(R.id.add_todo_fab)

        singleListAdapter = SingleListAdapter(requireContext(), testingData())
        singleListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        singleListRecyclerView.adapter = singleListAdapter

        viewModel = ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(SingleFragmentViewModel::class.java)

        dialogDismissed = object : DialogInterface {
            override fun dismiss() {
                toast("dismissed!")
            }

            override fun cancel() {
                toast("canceled!")
            }

        }
    }

    private fun toInputModel() {
        addToDoFab.hide()
    }

    private fun toBrowseModel() {
        addToDoFab.show()
    }

    private fun testingData(): ArrayList<ToDo> {
        return arrayListOf(
            ToDo("Red Sun", false),
            ToDo("Ink", true),
            ToDo("Cat", false),
            ToDo("Music", true),
            ToDo("Bt", true)
        )
    }
}
