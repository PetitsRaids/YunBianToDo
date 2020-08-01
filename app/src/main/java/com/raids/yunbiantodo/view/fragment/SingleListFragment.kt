package com.raids.yunbiantodo.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.raids.yunbiantodo.R
import com.raids.yunbiantodo.support.adapter.SingleListAdapter
import com.raids.yunbiantodo.base.BaseFragment
import com.raids.yunbiantodo.base.IDialogInterface
import com.raids.yunbiantodo.bean.ToDo
import com.raids.yunbiantodo.support.utils.MyConstValue
import com.raids.yunbiantodo.support.utils.toast
import com.raids.yunbiantodo.viewmodel.MainFragmentViewModel
import com.raids.yunbiantodo.viewmodel.SingleFragmentViewModel

class SingleListFragment : BaseFragment() {

    private lateinit var viewModel: SingleFragmentViewModel

    private lateinit var singleListRecyclerView: RecyclerView
    private lateinit var singleListAdapter: SingleListAdapter
    private lateinit var addToDoFab: FloatingActionButton
    private lateinit var linearLayout: LinearLayout
    private lateinit var addToDoEditText: EditText
    private lateinit var addToDoImageView: ImageView

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
            addToDoEditText.requestFocus()
        }
        addToDoImageView.setOnClickListener {
            viewModel.setInputState(MyConstValue.BROWSE_MODEL)
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

    override fun initView() {
        singleListRecyclerView = requireView().findViewById(R.id.singleList_recyclerView)
        addToDoFab = requireView().findViewById(R.id.add_todo_fab)
        toast(R.string.not_urgent_but_important)
        singleListAdapter = SingleListAdapter(requireContext(), testingData())
        singleListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        singleListRecyclerView.adapter = singleListAdapter

        linearLayout = requireView().findViewById(R.id.add_todo_layout)
        addToDoEditText = requireView().findViewById(R.id.add_todo_editText)
        addToDoImageView = requireView().findViewById(R.id.add_todo_imageView)

        viewModel = ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(SingleFragmentViewModel::class.java)
    }

    private fun toInputModel() {
        addToDoFab.hide()
        linearLayout.visibility = View.VISIBLE
    }

    private fun toBrowseModel() {
        addToDoFab.show()
        linearLayout.visibility = View.GONE
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
