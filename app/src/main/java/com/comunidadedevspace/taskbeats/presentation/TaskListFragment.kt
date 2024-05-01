package com.comunidadedevspace.taskbeats.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.comunidadedevspace.taskbeats.R
import com.comunidadedevspace.taskbeats.data.Task
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TaskListFragment : Fragment() {

    private lateinit var ctnContent: LinearLayout

    private val adapter: TaskListAdapter by lazy {
        TaskListAdapter(::openTaskListDetail)
    }

    private val viewModel: TaskListViewModel by lazy {
        TaskListViewModel.create(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ctnContent = view.findViewById(R.id.ctn_content)

        val rvTasks: RecyclerView = view.findViewById(R.id.rv_task_list)
        rvTasks.adapter = adapter

    }

    override fun onStart() {
        super.onStart()
        listFromDataBase()
    }

    private fun listFromDataBase(){
        //Observer
        val listObserver = Observer<List<Task>> {listTasks ->
            if (listTasks.isEmpty()){
                ctnContent.visibility = View.VISIBLE
            }else {
                ctnContent.visibility = View.GONE
            }
            adapter.submitList(listTasks)
        }
        //Live data
        viewModel.taskListLiveData.observe(this, listObserver)
    }

    private fun openTaskListDetail (task: Task)
    {
        val intent = TaskDetailActivity.start(requireContext(), task)
        requireActivity().startActivity(intent)
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            TaskListFragment()
                }
            }