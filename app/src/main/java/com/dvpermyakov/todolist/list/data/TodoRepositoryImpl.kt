package com.dvpermyakov.todolist.list.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dvpermyakov.todolist.list.domain.TodoItem
import com.dvpermyakov.todolist.list.domain.TodoRepository

class TodoRepositoryImpl : TodoRepository {
    private val items = MutableLiveData<List<TodoItem>>()

    override fun getItems(): LiveData<List<TodoItem>> {
        return items
    }

    override fun addItem(item: TodoItem) {
        items.value = (items.value ?: emptyList()).toMutableList().apply {
            add(item)
        }
    }

}