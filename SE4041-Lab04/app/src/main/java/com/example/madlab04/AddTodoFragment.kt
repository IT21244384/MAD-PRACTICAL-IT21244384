package com.example.madlab04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

/** Enter a new todo, or edit an existing one when opened from the list. */
class AddTodoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_add_todo, container, false)
        val viewModel = ViewModelProvider(requireActivity())[TodoViewModel::class.java]

        val tvHeading: TextView = rootView.findViewById(R.id.tvHeading)
        val edtTodo: EditText = rootView.findViewById(R.id.edtTodo)
        val btnSave: Button = rootView.findViewById(R.id.btnSaveTodo)

        val editing = viewModel.editing.value
        if (editing != null) {
            tvHeading.setText(R.string.edit_todo)
            btnSave.setText(R.string.save_changes)
            edtTodo.setText(editing.title)
            edtTodo.setSelection(edtTodo.text.length)
        }

        btnSave.setOnClickListener {
            val title = edtTodo.text.toString().trim()
            if (title.isEmpty()) {
                Toast.makeText(requireContext(), R.string.todo_empty, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (editing == null) {
                viewModel.addTodo(title)
                edtTodo.text.clear()
                Toast.makeText(requireContext(), R.string.todo_added, Toast.LENGTH_SHORT).show()
            } else {
                viewModel.updateTodo(editing.copy(title = title))
                viewModel.setEditing(null)
                Toast.makeText(requireContext(), R.string.todo_updated, Toast.LENGTH_SHORT).show()
                (requireActivity() as MainActivity).showTodoList()
            }
        }

        return rootView
    }
}
