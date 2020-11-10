package com.dvpermyakov.todolist.home.presentation

import androidx.lifecycle.ViewModel
import com.dvpermyakov.todolist.R
import com.dvpermyakov.todolist.home.ui.TodoItem

class HomeViewModel : ViewModel() {
    val items = (1..2).map { index ->
        TodoItem(
            image = R.drawable.ic_cat,
            title = index.toString(),
            description = index.toString()
        )
    }

    fun onTodoItemClick(item: TodoItem) {

    }

    fun onAddClick() {

    }
}