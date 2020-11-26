package com.dvpermyakov.todolist.detaills.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dvpermyakov.todolist.list.domain.TodoItem
import com.dvpermyakov.todolist.list.domain.TodoRepository

class TodoItemDetailsViewModel(
    private val repository: TodoRepository
) : ViewModel() {

    fun getItem(id: String): LiveData<TodoItem?> {
        return repository.getItem(id)
    }

}