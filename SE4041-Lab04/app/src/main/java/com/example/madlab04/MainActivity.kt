package com.example.madlab04

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[TodoViewModel::class.java]

        findViewById<Button>(R.id.btnAddTodo).setOnClickListener {
            viewModel.setEditing(null) // "Add Todo" always starts a new item
            showAddTodo()
        }
        findViewById<Button>(R.id.btnViewTodos).setOnClickListener {
            showTodoList()
        }

        if (savedInstanceState == null) {
            showAddTodo()
        }
    }

    // Public so the list can open the form in edit mode
    fun showAddTodo() = show(AddTodoFragment())

    fun showTodoList() = show(TodoListFragment())

    private fun show(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
