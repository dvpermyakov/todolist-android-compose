package com.dvpermyakov.todolist.list.presentation

import android.os.Handler
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

    private val _loading = MutableLiveData(true)
    val loading: LiveData<Boolean> = _loading

    val items: LiveData<List<TodoItem>>
        get() = repository.getItems()

    init {
        val item = TodoItem(
            image = R.drawable.ic_cat,
            title = "First title",
            description = "First description"
        )
        repository.addItem(item)
        Handler().postDelayed({
            _loading.value = false
        }, 1_000)
    }

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