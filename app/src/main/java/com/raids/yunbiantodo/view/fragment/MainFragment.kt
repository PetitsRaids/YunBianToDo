package com.raids.yunbiantodo.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raids.yunbiantodo.R
import com.raids.yunbiantodo.support.adapter.ToDoListAdapter
import com.raids.yunbiantodo.base.BaseFragment
import com.raids.yunbiantodo.room.bean.ToDo
import com.raids.yunbiantodo.room.bean.ToDoList
import com.raids.yunbiantodo.support.utils.MyConstValue
import com.raids.yunbiantodo.viewmodel.MainFragmentViewModel

class MainFragment : BaseFragment() {

    private lateinit var todoListRecyclerView: RecyclerView
    private lateinit var todoListAdapter: ToDoListAdapter
    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        todoListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        todoListRecyclerView.adapter = todoListAdapter
        viewModel.data?.observe(viewLifecycleOwner,
            Observer<ToDo> { TODO("Not yet implemented") })
    }

    override fun initViewAndData() {
        todoListRecyclerView = requireView().findViewById(R.id.todoList_recyclerView)
        todoListAdapter = ToDoListAdapter(
            requireContext(), arrayListOf(
                ToDoList(2, MyConstValue.EE),
                ToDoList(3, MyConstValue.UAI),
                ToDoList(4, MyConstValue.NUBI),
                ToDoList(5, MyConstValue.UBNI),
                ToDoList(6, MyConstValue.NAN),
                ToDoList(1, "ToDo")
            ))
        viewModel = ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(MainFragmentViewModel::class.java)
    }

}
