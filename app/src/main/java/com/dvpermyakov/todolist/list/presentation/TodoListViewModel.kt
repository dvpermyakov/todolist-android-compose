package com.dvpermyakov.todolist.list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dvpermyakov.todolist.R
import com.dvpermyakov.todolist.list.domain.TodoItem

class TodoListViewModel : ViewModel() {
    private val _showDialog = MutableLiveData(true)
    val showDialog: LiveData<Boolean> = _showDialog

    fun dialogShown() {
        _showDialog.value = false
    }

    val items = (1..2).map { index ->
        TodoItem(
            image = R.drawable.ic_cat,
            title = index.toString(),
            description = index.toString()
        )
    }
}