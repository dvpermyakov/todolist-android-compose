package com.dvpermyakov.todolist.add.presentation

import androidx.lifecycle.ViewModel
import com.dvpermyakov.todolist.list.domain.TodoRepository

class AddTodoViewModel(
    private val repository: TodoRepository
) : ViewModel() {

    fun addItem(title: String, description: String) {
        repository.addItem(title = title, description = description)
    }

}