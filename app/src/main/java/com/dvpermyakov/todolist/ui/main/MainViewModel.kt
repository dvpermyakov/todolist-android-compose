package com.dvpermyakov.todolist.ui.main

import androidx.lifecycle.ViewModel
import com.dvpermyakov.todolist.R

class MainViewModel : ViewModel() {
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