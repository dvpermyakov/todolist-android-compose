package com.dvpermyakov.todolist.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dvpermyakov.todolist.add.presentation.AddTodoViewModel
import com.dvpermyakov.todolist.list.data.TodoRepositoryImpl
import com.dvpermyakov.todolist.list.presentation.TodoListViewModel

object ViewModelFactory : ViewModelProvider.Factory {
    private val todoRepository = TodoRepositoryImpl()

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            AddTodoViewModel::class.java -> {
                AddTodoViewModel(
                    repository = todoRepository
                ) as T
            }
            TodoListViewModel::class.java -> {
                TodoListViewModel(
                    repository = todoRepository
                ) as T
            }
            else -> (object : ViewModel() {}) as T
        }
    }

}