package com.dvpermyakov.todolist.list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dvpermyakov.todolist.R
import com.dvpermyakov.todolist.list.domain.TodoItem
import com.dvpermyakov.todolist.list.domain.TodoRepository

class TodoListViewModel(
    private val repository: TodoRepository
) : ViewModel() {

    private val _showDialog = MutableLiveData(true)
    val showDialog: LiveData<Boolean> = _showDialog

    val items: LiveData<List<TodoItem>>
        get() = repository.getItems()

    fun dialogShown() {
        _showDialog.value = false
    }

    fun addDefaultTodoItem() {
        val item = TodoItem(
            image = R.drawable.ic_cat,
            title = "Default title",
            description = "Default description"
        )
        repository.addItem(item)
    }
}