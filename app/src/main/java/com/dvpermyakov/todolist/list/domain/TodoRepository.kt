package com.dvpermyakov.todolist.list.domain

import androidx.lifecycle.LiveData

interface TodoRepository {
    fun getItems(): LiveData<List<TodoItem>>
    fun addItem(item: TodoItem)
}