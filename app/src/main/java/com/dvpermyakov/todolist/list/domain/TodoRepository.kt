package com.dvpermyakov.todolist.list.domain

import androidx.lifecycle.LiveData

interface TodoRepository {
    fun getItems(): LiveData<List<TodoItem>>
    fun addItem(title: String, description: String)
    fun getItem(id: String): LiveData<TodoItem?>
}