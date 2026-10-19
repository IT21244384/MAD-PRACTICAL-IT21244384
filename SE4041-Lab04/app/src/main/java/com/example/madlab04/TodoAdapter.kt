package com.example.madlab04

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.madlab04.data.Todo

class TodoAdapter(
    private val items: List<Todo>,
    private val onToggle: (Todo, Boolean) -> Unit,
    private val onEdit: (Todo) -> Unit,
    private val onDelete: (Todo) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(view: android.view.View) : RecyclerView.ViewHolder(view) {
        val chkDone: CheckBox = view.findViewById(R.id.chkDone)
        val tvTitle: TextView = view.findViewById(R.id.tvTodoTitle)
        val btnEdit: Button = view.findViewById(R.id.btnEditTodo)
        val btnDelete: Button = view.findViewById(R.id.btnDeleteTodo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = items[position]
        holder.tvTitle.text = todo.title

        // Strike through completed items
        holder.tvTitle.paintFlags = if (todo.isDone) {
            holder.tvTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            holder.tvTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        // Remove the old listener before changing the state so recycling doesn't trigger it
        holder.chkDone.setOnCheckedChangeListener(null)
        holder.chkDone.isChecked = todo.isDone
        holder.chkDone.setOnCheckedChangeListener { _, checked -> onToggle(todo, checked) }

        holder.btnEdit.setOnClickListener { onEdit(todo) }
        holder.btnDelete.setOnClickListener { onDelete(todo) }
    }
}
