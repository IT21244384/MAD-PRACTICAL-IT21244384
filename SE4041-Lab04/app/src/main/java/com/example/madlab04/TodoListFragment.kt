package com.example.madlab04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/** Shows every todo in a RecyclerView with Edit / Delete / done checkbox. */
class TodoListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_todo_list, container, false)
        val rv: RecyclerView = rootView.findViewById(R.id.rvTodos)
        val tvEmpty: TextView = rootView.findViewById(R.id.tvEmpty)
        rv.layoutManager = LinearLayoutManager(requireContext())

        val viewModel = ViewModelProvider(requireActivity())[TodoViewModel::class.java]
        viewModel.loadTodos()

        // viewLifecycleOwner so the observer is removed together with this view
        viewModel.todos.observe(viewLifecycleOwner) { list ->
            tvEmpty.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE
            rv.adapter = TodoAdapter(
                list,
                onToggle = { todo, done -> viewModel.updateTodo(todo.copy(isDone = done)) },
                onEdit = { todo ->
                    viewModel.setEditing(todo)
                    (requireActivity() as MainActivity).showAddTodo()
                },
                onDelete = { todo ->
                    viewModel.deleteTodo(todo)
                    Toast.makeText(requireContext(), R.string.todo_deleted, Toast.LENGTH_SHORT).show()
                }
            )
        }

        return rootView
    }
}
