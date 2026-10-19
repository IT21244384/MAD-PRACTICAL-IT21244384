package com.example.madlab04

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.madlab04.data.Todo
import com.example.madlab04.data.TodoDatabase
import kotlinx.coroutines.launch

/** Shared by MainActivity and both fragments. */
class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = TodoDatabase.getInstance(application).todoDao()

    private val _todos = MutableLiveData<List<Todo>>(emptyList())
    val todos: LiveData<List<Todo>> = _todos

    // Todo currently being edited (null = adding a new one)
    private val _editing = MutableLiveData<Todo?>(null)
    val editing: LiveData<Todo?> = _editing

    fun setEditing(todo: Todo?) {
        _editing.value = todo
    }

    fun loadTodos() {
        viewModelScope.launch { _todos.value = dao.getAll() }
    }

    fun addTodo(title: String) {
        viewModelScope.launch {
            dao.insert(Todo(title = title))
            _todos.value = dao.getAll()
        }
    }

    fun updateTodo(todo: Todo) {
        viewModelScope.launch {
            dao.update(todo)
            _todos.value = dao.getAll()
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            dao.delete(todo)
            _todos.value = dao.getAll()
        }
    }
}
